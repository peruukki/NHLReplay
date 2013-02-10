function startGame()
{
  var data = JSON.parse(getJsonData());
  var teamTypes = setTeams(data["teams"]);
  startPeriod(new GameClock(), new GameEvents(data["gameEvents"], teamTypes),
              { "away":new Penalties('away'), "home":new Penalties('home') });
}

function setTeams(teams)
{
  var teamTypes = [];
  for (i in teams)
  {
    teamTypes[teams[i].abbreviation] = teams[i].type;
    $('#' + teams[i].type + '-team').text(teams[i].name);
  }
  return teamTypes;
}

function startPeriod(gameClock, gameEvents, penalties)
{
  var event = gameEvents.popEvent().event;
  gameClock.initTime(event.period, event.minLeft);
  setStatus('Period ' + event.period);
  decrementTime(gameClock, 5, gameEvents, penalties);
}

function decrementTime(gameClock, timeoutInMs, gameEvents, penalties)
{
  showClocks(gameClock, penalties);

  if (gameEvents.isEventNow(gameClock))
  {
    var event = gameEvents.popEvent();

    if (gameEvents.isEmpty())
    {
      setStatus('Game end!');
      return;
    }
    if (event.isPeriodEnd())
    {
      setStatus('Period end!');
      setTimeout(function() { startPeriod(gameClock, gameEvents, penalties); }, 1000);
      return;
    }

    if (event.isGoal())
    {
      showEvent(event);
      incrementValue(event, 'shots');
      incrementValue(event, 'score');
    }
    else if (event.isPenalty())
    {
      showEvent(event);
      addPenaltyClock(penalties, event);
    }
    else if (event.isShot())
    {
      incrementValue(event, 'shots');
    }
  }

  if (!gameEvents.isEventNow(gameClock))
  {
    advanceClocks(gameClock, penalties);
  }

  setTimeout(function() { decrementTime(gameClock, timeoutInMs, gameEvents, penalties); }, timeoutInMs);
}

function showClocks(gameClock, penalties)
{
  $('#game-clock').text(gameClock.show());
  for (i in penalties)
  {
    for (j in penalties[i].clocks)
    {
      $('#' + penalties[i].clocks[j].id).text(penalties[i].clocks[j].clock.show());
    }
  }
}

function advanceClocks(gameClock, penalties)
{
  var advanceDeciseconds = gameClock.advance();
  for (i in penalties)
  {
    var j = penalties[i].clocks.length;
    while (j--)
    {
      if (penalties[i].clocks[j].clock.isZero())
      {
        $('#' + penalties[i].clocks[j].id).remove();
        penalties[i].clocks.splice(j, 1);
      }
      else
      {
        penalties[i].clocks[j].clock.advance(advanceDeciseconds);
      }
    }
  }
}

function addPenaltyClock(penalties, event)
{
  var teamPenalties = penalties[event.teamType];
  var index = teamPenalties.count++;
  var id = event.teamType + '-penalty-' + index;
  var clock = new PenaltyClock();

  clock.initTime(event.event.duration);
  teamPenalties.clocks[teamPenalties.clocks.length] = { "clock":clock, "id":id };
  var clockElement = '<span class="time" id="' + id + '">' + clock.show() + '</span>';
  if ($('#' + teamPenalties.id).css('text-align') === 'right')
  {
    $('#' + teamPenalties.id).prepend(clockElement);
  }
  else
  {
    $('#' + teamPenalties.id).append(clockElement);
  }
}

function setStatus(status)
{
  $('#title-state').text(status);
}

function showEvent(event)
{
  $('.events').append('<p class="' + event.event.type + ' ' + event.teamType + '">' + event.show() + '</p>');
}

function incrementValue(event, valueType)
{
  var element = $('#' + event.teamType + '-' + valueType);
  var value = parseInt(element.text());
  element.text(value + 1);
}

function Penalties(teamType)
{
  this.count = 0;
  this.clocks = [];
  this.id = teamType + '-penalties';
}
