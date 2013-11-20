function GameEvents(events, teamTypes) {
  this.events = events;
  this.eventIndex = 0;
  this.teamTypes = teamTypes;

  this.isEventNow = function(clock) {
    return this.eventIndex < events.length &&
           clock.decisecond == 0 &&
           this.events[this.eventIndex].minLeft == clock.minute &&
           this.events[this.eventIndex].secLeft == clock.second;
  };

  this.popEvent = function() { return new GameEvent(this.events[this.eventIndex++], this.teamTypes); };
  this.isEmpty = function() { return this.eventIndex >= events.length; };
}

function GameEvent(event, teamTypes) {
  this.event = event;
  this.teamType = event.team ? teamTypes[event.team] : "";
  this.otherTeamType = event.otherTeam ? teamTypes[event.otherTeam] : "";
  this.wonTeamType = event.wonTeam ? teamTypes[event.wonTeam] : "";

  this.isGoal = function() { return this.event.type === 'GOAL'; };
  this.isPenalty = function() { return this.event.type === 'PENL'; };
  this.isPenaltyShot = function() { return this.event.type === 'PSHT'; };
  this.isPeriodEnd = function() { return this.event.type === 'PEND'; };
  this.isPeriodStart = function() { return this.event.type === 'PSTR'; };
  this.isGoalAttempt = function() { return this.event.type === 'GATT'; };
  this.isShotOnGoal = function() { return this.event.type === 'SHOT'; };
  this.isMissedShot = function() { return this.event.type === 'MISS'; };
  this.isBlockedShot = function() { return this.event.type === 'BLOCK'; };
  this.isFaceoff = function() { return this.event.type === 'FAC'; };
  this.isHit = function() { return this.event.type === 'HIT'; };
  this.isNotificationEvent = function() { return !(this.isFaceoff() || this.isHit()); };

  this.show = function() {
    if (this.isPeriodStart()) {
      return getPeriod(this.event.period, this.event.minLeft).longName;
    }
    else {
      return showTimedEvent(this);
    }
  };

  this.showShortPeriodName = function() {
    return getPeriod(this.event.period, this.event.minLeft).shortName;
  }

  function getPeriod(period, periodMinutes) {
    if (periodMinutes == 0) {
      return new Period('SO', 'Shootout');
    }
    if (periodMinutes == 5) {
      return new Period('OT', 'Overtime');
    }

    var otStr = ''
    if (period > 3) {
      // Playoff overtime
      period -= 3;
      otStr = ' OT';
    }
    var ordinalStr = 'th';
    if (period === 1) ordinalStr = 'st';
    if (period === 2) ordinalStr = 'nd';
    if (period === 3) ordinalStr = 'rd';
    var periodShortName = period + ordinalStr + otStr;
    return new Period(periodShortName, periodShortName + ' period');
  }

  function showTimedEvent(gameEvent) {
    function cell(cssClass, content) { return '<td class="event-' + cssClass + '">' + content + '</td>'; }
    function showAssists(event) {
      var content;
      if (event.assist2nd) { content = 'Assists: ' + event.assist1st + ' & ' + event.assist2nd; }
      else if (event.assist1st) { content = 'Assist: ' + event.assist1st; }
      else { content = 'Unassisted'; }
      return '<tr><td/><td/><td/>' + cell('assists', content) + '</tr>';
    }

    var event = gameEvent.event;
    var time = showEventTime(event.minElapsed, event.secElapsed, event.period);
    var output = '<table><tr>' + cell('time', time) + cell('team', event.team);

    if (gameEvent.isGoal()) {
      output += cell('strength', event.strength) + cell('scorer', event.player) + '</tr>';
      output += showAssists(event)
    }
    else {
      output += cell("type", event.type) + '</tr>';
    }
    output += '</table>';
    return output;
  }

  function showEventTime(minute, second, period) {
    if (second < 10) {
      second = '0' + second;
    }
    return minute + ':' + second;
  }
}

function Period(shortName, longName) {
  this.shortName = shortName;
  this.longName = longName;
}
