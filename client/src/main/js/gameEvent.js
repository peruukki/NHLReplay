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

  this.isGoal = function() { return this.event.type === 'GOAL'; };
  this.isPenalty = function() { return this.event.type === 'PENL'; };
  this.isPeriodEnd = function() { return this.event.type === 'PEND'; };
  this.isPeriodStart = function() { return this.event.type === 'PSTR'; };
  this.isGoalAttempt = function() { return this.event.type === 'GATT'; };
  this.isShotOnGoal = function() { return this.event.type === 'SHOT'; };
  this.isMissedShot = function() { return this.event.type === 'MISS'; };

  this.show = function() {
    if (this.isPeriodStart()) {
      return this.showPeriod() + " period";
    }
    else {
      return showTimedEvent(this);
    }
  };
  this.showPeriod = function() {
    var period = this.event.period;
    var ordinalStr = 'th';
    if (period === 1) ordinalStr = 'st';
    if (period === 2) ordinalStr = 'nd';
    if (period === 3) ordinalStr = 'rd';
    return period + ordinalStr;
  };

  function showTimedEvent(gameEvent) {
    var event = gameEvent.event;
    var output = showEventTime(event.minElapsed, event.secElapsed, event.period) + ' ' + event.team + ' ';
    if (gameEvent.isGoal()) {
      output += event.strength + ' ' + event.shooter + ' ' + event.goalCount + ' ';
      if (event.assist2nd) {
        output += 'Assists: ' + event.assist1st + ' ' + event.assist1stCount + ' & ' + event.assist2nd + ' ' + event.assist2ndCount;
      }
      else if (event.assist1st) {
        output += 'Assist: ' + event.assist1st + ' ' + event.assist1stCount;
      }
      else {
        output += 'Unassisted';
      }
    }
    else if (gameEvent.isPenalty()) {
      output += event.taker + ' ' + event.reason;
    }
    else if (gameEvent.isShotOnGoal()) {
      output += event.shooter;
    }
    else {
      output += event.type;
    }
    return output;
  }

  function showEventTime(minute, second, period) {
    if (second < 10) {
      second = '0' + second;
    }
    return minute + ':' + second;
  }
}
