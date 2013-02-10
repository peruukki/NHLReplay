function GameClock()
{
  this.initTime = function(period, minutes)
  {
    this.period = period;
    clockInit_(this, minutes);
  };

  this.show = function()
  {
    if (this.minute == 0)
    {
      return this.second + '.' + this.decisecond;
    }
    return clockShowMinutes_(this);
  };

  this.advance = function() { return clockAdvance_(this, this.minute == 0); };
}

function PenaltyClock()
{
  this.initTime = function(minutes) { clockInit_(this, minutes); };
  this.show = function() { return clockShowMinutes_(this); };
  this.advance = function(byDecisecond) { return clockAdvance_(this, byDecisecond); };
  this.isZero = function() { return this.minute == 0 && this.second == 0; }
}

function clockInit_(clock, minutes)
{
  clock.minute = minutes;
  clock.second = 0;
  clock.decisecond = 0;
}

function clockShowMinutes_(clock)
{
  var second = clock.second;
  if (second < 10)
  {
    second = '0' + second;
  }
  return clock.minute + ':' + second;
}

function clockAdvance_(clock, byDecisecond)
{
  if (byDecisecond)
  {
    if (clock.decisecond > 0)
    {
      clock.decisecond--;
    }
    else
    {
      if (clock.second > 0)
      {
        clock.second--;
      }
      else
      {
        clock.minute--;
        clock.second = 59;
      }
      clock.decisecond = 9;
    }
    return true;
  }
  else
  {
    if (clock.second > 0)
    {
      clock.second--;
    }
    else
    {
      clock.minute--;
      clock.second = 59;
    }
    clock.decisecond = 0;
    return false;
  }
}
