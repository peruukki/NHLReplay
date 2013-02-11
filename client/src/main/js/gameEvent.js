function GameEvents(events, teamTypes)
{
  this.events = events;
  this.eventIndex = 0;
  this.teamTypes = teamTypes;

  this.isEventNow = function(clock)
  {
    return this.eventIndex < events.length &&
           clock.decisecond == 0 &&
           this.events[this.eventIndex].minLeft == clock.minute &&
           this.events[this.eventIndex].secLeft == clock.second;
  };

  this.popEvent = function() { return new GameEvent(this.events[this.eventIndex++], this.teamTypes); };
  this.isEmpty = function() { return this.eventIndex >= events.length; };
}

function GameEvent(event, teamTypes)
{
  this.event = event;
  this.teamType = teamTypes[event.team];

  this.isGoal = function() { return this.event.type === 'GOAL'; };
  this.isPenalty = function() { return this.event.type === 'PENL'; };
  this.isPeriodEnd = function() { return this.event.type === 'PEND'; };
  this.isPeriodStart = function() { return this.event.type === 'PSTR'; };
  this.isGoalAttempt = function() { return this.event.type === 'GATT'; };
  this.isShotOnGoal = function() { return this.event.type === 'SHOT'; };
  this.isMissedShot = function() { return this.event.type === 'MISS'; };

  this.show = function()
  {
    var event = this.event;
    var output = showEventTime(event.minElapsed, event.secElapsed, event.period) + ' ' + event.team + ' ';
    if (this.isGoal(event))
    {
      output += event.strength + ' ' + event.shooter + ' ';
      if (event.assist_2nd)
      {
        output += 'Assists: ' + event.assist_1st + ' & ' + event.assist_2nd;
      }
      else if (event.assist_1st)
      {
        output += 'Assist: ' + event.assist_1st;
      }
      else
      {
        output += 'Unassisted';
      }
    }
    else if (this.isPenalty())
    {
      output += event.taker + ' ' + event.reason;
    }
    else if (this.isShotOnGoal())
    {
      output += event.shooter;
    }
    else
    {
      output += event.type;
    }
    return output;
  };

  function showEventTime(minute, second, period)
  {
    if (second < 10)
    {
      second = '0' + second;
    }
    return (minute + (period - 1) * 20) + ':' + second;
  }
}
