var _gameDelayInMs;
var _gameClock;
var _gameEvents;
var _gamePenalties;

function gameInit() {
  $('#button-play').click(function() { playClick($(this)); return false; });

  var data = JSON.parse(getJsonData());
  var teamTypes = setTeams(data["teams"]);
  _gameDelayInMs = 5;
  _gameClock = new GameClock();
  _gameEvents = new GameEvents(data["gameEvents"], teamTypes);
  _gamePenalties = { "away": new Penalties('away'), "home": new Penalties('home') };
  startPeriod();
}

function playClick(button) {
  if (isGameOver()) return;

  if (button.text() === 'Pause') {
    button.text('Resume');
    _gameClock.isRunning = false;
  }
  else {
    button.text('Pause');
    _gameClock.isRunning = true;
    decrementTime();
  }
}

function setTeams(teams) {
  var teamTypes = [];
  for (i in teams) {
    teamTypes[teams[i].abbreviation] = teams[i].type;
    $('#' + teams[i].type + '-team').text(teams[i].name);
  }
  return teamTypes;
}

function startPeriod() {
  var event = _gameEvents.popEvent();
  _gameClock.initTime(event.event.period, event.event.minLeft);
  setStatus(event.showShortPeriodName());
  showEvent(event);
  decrementTime();
}

function decrementTime() {
  var baseWaitInMs = 1000;
  var extraWaitInMs = 0;

  if (!_gameClock.isRunning) return;

  showClocks(_gameClock, _gamePenalties);

  if (_gameEvents.isEventNow(_gameClock)) {
    var event = _gameEvents.popEvent();

    if (isGameOver()) {
      setStatus('Game end!');
      return;
    }
    if (event.isPeriodEnd()) {
      setStatus('Period end!');
      setTimeout(function() { startPeriod(); }, 3 * baseWaitInMs);
      return;
    }

    if (event.isGoal()) {
      showEvent(event);
      incrementValue(event.teamType, 'shots', 1);
      incrementValue(event.teamType, 'score', 1);
      extraWaitInMs += 4 * baseWaitInMs;
    }
    else if (event.isPenalty()) {
      addPenaltyClock(_gamePenalties, event);
      incrementValue(event.teamType, 'pim', event.event.duration);
      extraWaitInMs += 4 * baseWaitInMs;
    }
    else if (event.isShotOnGoal()) {
      incrementValue(event.teamType, 'shots', 1);
    }
    else if (event.isMissedShot()) {
      incrementValue(event.teamType, 'shots-off-target', 1);
    }
    else if (event.isBlockedShot()) {
      incrementValue(event.otherTeamType, 'shots-blocked', 1);
    }
    else if (event.isFaceoff()) {
      incrementValue(event.wonTeamType, 'faceoffs', 1);
    }
    else if (event.isHit()) {
      incrementValue(event.teamType, 'hits', 1);
    }

    if (event.isNotificationEvent()) {
      showNotification(event);
      extraWaitInMs += baseWaitInMs;
    }
    else {
      clearNotification();
    }
  }
  else {
    clearNotification();
  }

  if (!_gameEvents.isEventNow(_gameClock)) {
    advanceClocks(_gameClock, _gamePenalties);
  }

  setTimeout(function() { decrementTime(); }, _gameDelayInMs + extraWaitInMs);
}

function isGameOver() {
  return _gameEvents.isEmpty();
}

function showClocks(gameClock, penalties) {
  $('#game-clock').text(gameClock.show());
  for (i in penalties) {
    for (j in penalties[i].clocks) {
      $('#' + penalties[i].clocks[j].id).text(penalties[i].clocks[j].clock.show());
    }
  }
}

function advanceClocks(gameClock, penalties) {
  var advanceDeciseconds = gameClock.advance();
  for (i in penalties) {
    var j = penalties[i].clocks.length;
    while (j--) {
      if (penalties[i].clocks[j].clock.isZero()) {
        $('#' + penalties[i].clocks[j].id).remove();
        penalties[i].clocks.splice(j, 1);
      }
      else {
        penalties[i].clocks[j].clock.advance(advanceDeciseconds);
      }
    }
  }
}

function addPenaltyClock(penalties, event) {
  var teamPenalties = penalties[event.teamType];
  var index = teamPenalties.count++;
  var id = event.teamType + '-penalty-' + index;
  var clock = new PenaltyClock();

  clock.initTime(event.event.duration);
  teamPenalties.clocks[teamPenalties.clocks.length] = { "clock":clock, "id":id };
  var clockElement = '<span class="time" id="' + id + '">' + clock.show() + '</span>';
  if ($('#' + teamPenalties.id).css('text-align') === 'right') {
    $('#' + teamPenalties.id).prepend(clockElement);
  }
  else {
    $('#' + teamPenalties.id).append(clockElement);
  }
}

function setStatus(status) {
  $('#title-state').text(status);
}

function showEvent(event) {
  $('.events').append('<div class="event ' + event.event.type + ' ' + event.teamType + '">' + event.show() + '</div>');
}

function showNotification(event) {
  var content = $('.notifications').text();

  if (event.isGoalAttempt()) {
    content = event.event.player + ' ' + event.event.shotType;
    if (event.event.distance) content += " from " + convertLength(event.event.distance);
    content += '...';
  }
  else if (event.isShotOnGoal()) {
    content += ' saved!';
  }
  else if (event.isMissedShot()) {
    content += ' ' + event.event.target + '!';
  }
  else if (event.isBlockedShot()) {
    content += ' blocked by ' + event.event.otherPlayer + '.';
  }
  else if (event.isGoal()) {
    content += ' he scores!';
  }
  else if (event.isPenalty()) {
    content = event.event.player + ' gets a ' + event.event.duration + ' min penalty for ' + event.event.reason + '.';
  }
  else if (event.isPenaltyShot()) {
    content = event.event.player + ' is awarded a penalty shot!';
  }
  else {
    content = '';
  }

  $('.notifications').html('<p class="' + event.teamType + '">' + content + '</p>');
}

function clearNotification() {
  $('.notifications').text('');
}

function incrementValue(teamType, valueType, increment) {
  var element = $('#' + teamType + '-' + valueType);
  var value = parseInt(element.text());
  element.text(value + increment);
}

function convertLength(length) {
  var lengthItems = length.split(' ');
  var quantity = lengthItems[0];
  var unit = lengthItems[1];
  var convertedLength = "0 ?";

  if (unit === "ft") {
    var convertedQuantity = (parseFloat(quantity) * 0.3048).toFixed(0);
    convertedLength = convertedQuantity + " m";
  }

  return convertedLength;
}

function Penalties(teamType) {
  this.count = 0;
  this.clocks = [];
  this.id = teamType + '-penalties';
}
