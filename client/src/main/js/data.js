function getJsonData() {
  var data = '{ ';

  data += '"gameEvents": [' +
    '{ "period":1, "minElapsed":0, "secElapsed":0, "minLeft":20, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":1, "minElapsed":1, "secElapsed":15, "minLeft":18, "secLeft":45, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#47 KOMAROV" },' +
    '{ "period":1, "minElapsed":1, "secElapsed":22, "minLeft":18, "secLeft":38, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK" },' +
    '{ "period":1, "minElapsed":1, "secElapsed":30, "minLeft":18, "secLeft":30, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":1, "secElapsed":45, "minLeft":18, "secLeft":15, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#12 STAAL" },' +
    '{ "period":1, "minElapsed":2, "secElapsed":53, "minLeft":17, "secLeft":7, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#38 MCLAREN" },' +
    '{ "period":1, "minElapsed":2, "secElapsed":55, "minLeft":17, "secLeft":5, "type":"PENL", "strength":"EV", "team":"CAR", "taker":"#8 WESTGARTH", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":1, "minElapsed":2, "secElapsed":55, "minLeft":17, "secLeft":5, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#38 MCLAREN", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":1, "minElapsed":3, "secElapsed":22, "minLeft":16, "secLeft":38, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#25 PITKANEN" },' +
    '{ "period":1, "minElapsed":4, "secElapsed":0, "minLeft":16, "secLeft":0, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":1, "minElapsed":4, "secElapsed":33, "minLeft":15, "secLeft":27, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#41 KULEMIN" },' +
    '{ "period":1, "minElapsed":5, "secElapsed":4, "minLeft":14, "secLeft":56, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#39 FRATTIN" },' +
    '{ "period":1, "minElapsed":5, "secElapsed":42, "minLeft":14, "secLeft":18, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":1, "minElapsed":5, "secElapsed":44, "minLeft":14, "secLeft":16, "type":"GOAL", "strength":"EV", "team":"TOR", "scorer":"#39 FRATTIN(5)", "assist_1st":"#43 KADRI(5)", "assist_2nd":"#47 KOMAROV(2)" },' +
    '{ "period":1, "minElapsed":6, "secElapsed":13, "minLeft":13, "secLeft":47, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#19 TLUSTY" },' +
    '{ "period":1, "minElapsed":7, "secElapsed":9, "minLeft":12, "secLeft":51, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#53 SKINNER" },' +
    '{ "period":1, "minElapsed":7, "secElapsed":35, "minLeft":12, "secLeft":25, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":1, "minElapsed":7, "secElapsed":35, "minLeft":12, "secLeft":25, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#41 KULEMIN" },' +
    '{ "period":1, "minElapsed":7, "secElapsed":35, "minLeft":12, "secLeft":25, "type":"PENL", "strength":"EV", "team":"CAR", "taker":"#4 MCBAIN", "reason":"Hi-sticking(2 min)", "duration":2 },' +
    '{ "period":1, "minElapsed":8, "secElapsed":16, "minLeft":11, "secLeft":44, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":1, "minElapsed":8, "secElapsed":26, "minLeft":11, "secLeft":34, "type":"SHOT", "strength":"SH", "team":"CAR", "shooter":"#39 DWYER" },' +
    '{ "period":1, "minElapsed":10, "secElapsed":45, "minLeft":9, "secLeft":15, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#37 BRENT" },' +
    '{ "period":1, "minElapsed":11, "secElapsed":5, "minLeft":8, "secLeft":55, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#24 SANGUINETTI" },' +
    '{ "period":1, "minElapsed":11, "secElapsed":31, "minLeft":8, "secLeft":29, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#28 SEMIN" },' +
    '{ "period":1, "minElapsed":12, "secElapsed":30, "minLeft":7, "secLeft":30, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":12, "secElapsed":58, "minLeft":7, "secLeft":2, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#36 JOKINEN" },' +
    '{ "period":1, "minElapsed":13, "secElapsed":7, "minLeft":6, "secLeft":53, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#27 FAULK" },' +
    '{ "period":1, "minElapsed":13, "secElapsed":54, "minLeft":6, "secLeft":6, "type":"PENL", "strength":"EV", "team":"CAR", "taker":"#8 WESTGARTH", "reason":"Tripping(2 min)", "duration":2 },' +
    '{ "period":1, "minElapsed":14, "secElapsed":7, "minLeft":5, "secLeft":53, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":14, "secElapsed":30, "minLeft":5, "secLeft":30, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":1, "minElapsed":15, "secElapsed":20, "minLeft":4, "secLeft":40, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":1, "minElapsed":15, "secElapsed":29, "minLeft":4, "secLeft":31, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#3 PHANEUF" },' +
    '{ "period":1, "minElapsed":17, "secElapsed":9, "minLeft":2, "secLeft":51, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#28 SEMIN" },' +
    '{ "period":1, "minElapsed":17, "secElapsed":14, "minLeft":2, "secLeft":46, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#44 HARRISON" },' +
    '{ "period":1, "minElapsed":17, "secElapsed":37, "minLeft":2, "secLeft":23, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#84 GRABOVSKI" },' +
    '{ "period":1, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"PEND", "strength":" " },' +
    '{ "period":2, "minElapsed":0, "secElapsed":0, "minLeft":20, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":2, "minElapsed":1, "secElapsed":21, "minLeft":18, "secLeft":39, "type":"GOAL", "strength":"EV", "team":"CAR", "scorer":"#11 STAAL(1)", "assist_1st":"#39 DWYER(1)", "assist_2nd":"#53 SKINNER(2)" },' +
    '{ "period":2, "minElapsed":2, "secElapsed":21, "minLeft":17, "secLeft":39, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#21 BOWMAN" },' +
    '{ "period":2, "minElapsed":2, "secElapsed":21, "minLeft":17, "secLeft":39, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#44 HARRISON" },' +
    '{ "period":2, "minElapsed":2, "secElapsed":58, "minLeft":17, "secLeft":2, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#37 BRENT" },' +
    '{ "period":2, "minElapsed":3, "secElapsed":33, "minLeft":16, "secLeft":27, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#19 TLUSTY" },' +
    '{ "period":2, "minElapsed":3, "secElapsed":35, "minLeft":16, "secLeft":25, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#12 STAAL" },' +
    '{ "period":2, "minElapsed":4, "secElapsed":12, "minLeft":15, "secLeft":48, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#19 TLUSTY" },' +
    '{ "period":2, "minElapsed":4, "secElapsed":18, "minLeft":15, "secLeft":42, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#28 SEMIN" },' +
    '{ "period":2, "minElapsed":4, "secElapsed":48, "minLeft":15, "secLeft":12, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#53 SKINNER" },' +
    '{ "period":2, "minElapsed":5, "secElapsed":12, "minLeft":14, "secLeft":48, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":2, "minElapsed":5, "secElapsed":36, "minLeft":14, "secLeft":24, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#39 FRATTIN" },' +
    '{ "period":2, "minElapsed":6, "secElapsed":19, "minLeft":13, "secLeft":41, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#59 LAROSE" },' +
    '{ "period":2, "minElapsed":6, "secElapsed":31, "minLeft":13, "secLeft":29, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#21 BOWMAN" },' +
    '{ "period":2, "minElapsed":6, "secElapsed":40, "minLeft":13, "secLeft":20, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#84 GRABOVSKI" },' +
    '{ "period":2, "minElapsed":7, "secElapsed":22, "minLeft":12, "secLeft":38, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":2, "minElapsed":7, "secElapsed":55, "minLeft":12, "secLeft":5, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#39 DWYER" },' +
    '{ "period":2, "minElapsed":9, "secElapsed":20, "minLeft":10, "secLeft":40, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#21 BOWMAN" },' +
    '{ "period":2, "minElapsed":9, "secElapsed":41, "minLeft":10, "secLeft":19, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#11 MCCLEMENT", "reason":"Unsportsmanlike conduct(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":9, "secElapsed":50, "minLeft":10, "secLeft":10, "type":"SHOT", "strength":"SH", "team":"TOR", "shooter":"#41 KULEMIN" },' +
    '{ "period":2, "minElapsed":10, "secElapsed":21, "minLeft":9, "secLeft":39, "type":"GOAL", "strength":"PP", "team":"CAR", "scorer":"#12 STAAL(7)", "assist_1st":"#19 TLUSTY(2)", "assist_2nd":"#37 BRENT(1)" },' +
    '{ "period":2, "minElapsed":11, "secElapsed":48, "minLeft":8, "secLeft":12, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#45 FRASER", "reason":"Boarding(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":12, "secElapsed":12, "minLeft":7, "secLeft":48, "type":"SHOT", "strength":"PP", "team":"CAR", "shooter":"#19 TLUSTY" },' +
    '{ "period":2, "minElapsed":12, "secElapsed":46, "minLeft":7, "secLeft":14, "type":"SHOT", "strength":"PP", "team":"CAR", "shooter":"#27 FAULK" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":5, "minLeft":6, "secLeft":55, "type":"PENL", "strength":"PP", "team":"CAR", "taker":"#4 MCBAIN", "reason":"Hooking(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":14, "secElapsed":23, "minLeft":5, "secLeft":37, "type":"SHOT", "strength":"SH", "team":"CAR", "shooter":"#28 SEMIN" },' +
    '{ "period":2, "minElapsed":16, "secElapsed":19, "minLeft":3, "secLeft":41, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#53 SKINNER" },' +
    '{ "period":2, "minElapsed":19, "secElapsed":15, "minLeft":0, "secLeft":45, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#53 SKINNER" },' +
    '{ "period":2, "minElapsed":19, "secElapsed":16, "minLeft":0, "secLeft":44, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#53 KOSTKA", "reason":"Tripping(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":19, "secElapsed":46, "minLeft":0, "secLeft":14, "type":"PENL", "strength":"SH", "team":"TOR", "taker":"#55 HOLZER", "reason":"Tripping(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":19, "secElapsed":56, "minLeft":0, "secLeft":4, "type":"SHOT", "strength":"PP", "team":"CAR", "shooter":"#12 STAAL" },' +
    '{ "period":2, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"PEND", "strength":" " },' +
    '{ "period":3, "minElapsed":0, "secElapsed":0, "minLeft":20, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":3, "minElapsed":0, "secElapsed":20, "minLeft":19, "secLeft":40, "type":"SHOT", "strength":"PP", "team":"CAR", "shooter":"#12 STAAL" },' +
    '{ "period":3, "minElapsed":0, "secElapsed":43, "minLeft":19, "secLeft":17, "type":"GOAL", "strength":"PP", "team":"CAR", "scorer":"#27 FAULK(2)", "assist_1st":"#53 SKINNER(3)", "assist_2nd":"#28 SEMIN(5)" },' +
    '{ "period":3, "minElapsed":2, "secElapsed":8, "minLeft":17, "secLeft":52, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":3, "minElapsed":2, "secElapsed":24, "minLeft":17, "secLeft":36, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#24 LILES" },' +
    '{ "period":3, "minElapsed":3, "secElapsed":20, "minLeft":16, "secLeft":40, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":56, "minLeft":15, "secLeft":4, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#19 TLUSTY" },' +
    '{ "period":3, "minElapsed":6, "secElapsed":4, "minLeft":13, "secLeft":56, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#21 BOWMAN" },' +
    '{ "period":3, "minElapsed":6, "secElapsed":21, "minLeft":13, "secLeft":39, "type":"PENL", "strength":"EV", "team":"CAR", "taker":"#28 SEMIN", "reason":"Hooking(2 min)", "duration":2 },' +
    '{ "period":3, "minElapsed":6, "secElapsed":41, "minLeft":13, "secLeft":19, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":9, "minLeft":12, "secLeft":51, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#3 PHANEUF" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":19, "minLeft":12, "secLeft":41, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#24 LILES" },' +
    '{ "period":3, "minElapsed":8, "secElapsed":2, "minLeft":11, "secLeft":58, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#41 KULEMIN" },' +
    '{ "period":3, "minElapsed":8, "secElapsed":3, "minLeft":11, "secLeft":57, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":3, "minElapsed":8, "secElapsed":18, "minLeft":11, "secLeft":42, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#3 PHANEUF" },' +
    '{ "period":3, "minElapsed":8, "secElapsed":42, "minLeft":11, "secLeft":18, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK" },' +
    '{ "period":3, "minElapsed":9, "secElapsed":50, "minLeft":10, "secLeft":10, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#29 WALLACE" },' +
    '{ "period":3, "minElapsed":9, "secElapsed":58, "minLeft":10, "secLeft":2, "type":"GOAL", "strength":"EV", "team":"CAR", "scorer":"#39 DWYER(3)", "assist_1st":"#11 STAAL(7)", "assist_2nd":"#53 SKINNER(4)" },' +
    '{ "period":3, "minElapsed":10, "secElapsed":12, "minLeft":9, "secLeft":48, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":3, "minElapsed":10, "secElapsed":18, "minLeft":9, "secLeft":42, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#3 PHANEUF" },' +
    '{ "period":3, "minElapsed":11, "secElapsed":57, "minLeft":8, "secLeft":3, "type":"SHOT", "strength":"EV", "team":"CAR", "shooter":"#53 SKINNER" },' +
    '{ "period":3, "minElapsed":13, "secElapsed":20, "minLeft":6, "secLeft":40, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#24 LILES" },' +
    '{ "period":3, "minElapsed":14, "secElapsed":1, "minLeft":5, "secLeft":59, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":3, "minElapsed":14, "secElapsed":10, "minLeft":5, "secLeft":50, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":3, "minElapsed":14, "secElapsed":16, "minLeft":5, "secLeft":44, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#4 FRANSON" },' +
    '{ "period":3, "minElapsed":15, "secElapsed":8, "minLeft":4, "secLeft":52, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#41 KULEMIN" },' +
    '{ "period":3, "minElapsed":18, "secElapsed":52, "minLeft":1, "secLeft":8, "type":"PENL", "strength":"EV", "team":"CAR", "taker":"#37 BRENT", "reason":"Holding(2 min)", "duration":2 },' +
    '{ "period":3, "minElapsed":19, "secElapsed":5, "minLeft":0, "secLeft":55, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":3, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":3, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"PEND", "strength":" " }' +
  ']';

  data += ',';

  data += '"teams": [' +
    '{ "type":"home", "name":"TORONTO MAPLE LEAFS", "abbreviation":"TOR" },' +
    '{ "type":"away", "name":"CAROLINA HURRICANES", "abbreviation":"CAR" }' +
  ']';

/*
  data += '"gameEvents": [' +
    '{ "period":1, "minElapsed":0, "secElapsed":0, "minLeft":20, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":1, "minElapsed":3, "secElapsed":12, "minLeft":16, "secLeft":48, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#37 ELLIS" },' +
    '{ "period":1, "minElapsed":8, "secElapsed":18, "minLeft":11, "secLeft":42, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":1, "minElapsed":8, "secElapsed":36, "minLeft":11, "secLeft":24, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#26 VANEK" },' +
    '{ "period":1, "minElapsed":9, "secElapsed":23, "minLeft":10, "secLeft":37, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":1, "minElapsed":9, "secElapsed":25, "minLeft":10, "secLeft":35, "type":"GOAL", "strength":"EV", "team":"TOR", "scorer":"#11 MCCLEMENT(1)", "assist_1st":"#43 KADRI(3)", "assist_2nd":"#41 KULEMIN(5)" },' +
    '{ "period":1, "minElapsed":9, "secElapsed":50, "minLeft":10, "secLeft":10, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":1, "minElapsed":12, "secElapsed":4, "minLeft":7, "secLeft":56, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#55 HECHT" },' +
    '{ "period":1, "minElapsed":13, "secElapsed":3, "minLeft":6, "secLeft":57, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#84 GRABOVSKI" },' +
    '{ "period":1, "minElapsed":13, "secElapsed":4, "minLeft":6, "secLeft":56, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#18 BROWN", "reason":"Delay Gm - Face-off Violation(2 min)", "duration":2 },' +
    '{ "period":1, "minElapsed":14, "secElapsed":24, "minLeft":5, "secLeft":36, "type":"SHOT", "strength":"PP", "team":"BUF", "shooter":"#26 VANEK" },' +
    '{ "period":1, "minElapsed":14, "secElapsed":28, "minLeft":5, "secLeft":32, "type":"GOAL", "strength":"PP", "team":"BUF", "scorer":"#29 POMINVILLE(4)", "assist_1st":"#82 FOLIGNO(1)", "assist_2nd":"#26 VANEK(7)" },' +
    '{ "period":1, "minElapsed":17, "secElapsed":34, "minLeft":2, "secLeft":26, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#18 BROWN", "reason":"Boarding(2 min)", "duration":2 },' +
    '{ "period":1, "minElapsed":17, "secElapsed":34, "minLeft":2, "secLeft":26, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#18 BROWN", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":1, "minElapsed":17, "secElapsed":34, "minLeft":2, "secLeft":26, "type":"PENL", "strength":"EV", "team":"BUF", "taker":"#6 WEBER", "reason":"Instigator(2 min)", "duration":2 },' +
    '{ "period":1, "minElapsed":17, "secElapsed":34, "minLeft":2, "secLeft":26, "type":"PENL", "strength":"EV", "team":"BUF", "taker":"#6 WEBER", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":1, "minElapsed":17, "secElapsed":34, "minLeft":2, "secLeft":26, "type":"PENL", "strength":"EV", "team":"BUF", "taker":"#6 WEBER", "reason":"Misconduct (10 min)(10 min)", "duration":10 },' +
    '{ "period":1, "minElapsed":17, "secElapsed":55, "minLeft":2, "secLeft":5, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#47 KOMAROV" },' +
    '{ "period":1, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"PEND", "strength":" " },' +
    '{ "period":2, "minElapsed":0, "secElapsed":0, "minLeft":20, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":2, "minElapsed":0, "secElapsed":15, "minLeft":19, "secLeft":45, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#21 STAFFORD" },' +
    '{ "period":2, "minElapsed":0, "secElapsed":19, "minLeft":19, "secLeft":41, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#3 LEOPOLD" },' +
    '{ "period":2, "minElapsed":1, "secElapsed":2, "minLeft":18, "secLeft":58, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#10 EHRHOFF" },' +
    '{ "period":2, "minElapsed":1, "secElapsed":7, "minLeft":18, "secLeft":53, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#82 FOLIGNO" },' +
    '{ "period":2, "minElapsed":1, "secElapsed":33, "minLeft":18, "secLeft":27, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#45 FRASER" },' +
    '{ "period":2, "minElapsed":2, "secElapsed":28, "minLeft":17, "secLeft":32, "type":"GOAL", "strength":"EV", "team":"BUF", "scorer":"#44 SEKERA(1)", "assist_1st":"#21 STAFFORD(3)", "assist_2nd":"#10 EHRHOFF(4)" },' +
    '{ "period":2, "minElapsed":3, "secElapsed":20, "minLeft":16, "secLeft":40, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#44 SEKERA" },' +
    '{ "period":2, "minElapsed":3, "secElapsed":34, "minLeft":16, "secLeft":26, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#44 SEKERA" },' +
    '{ "period":2, "minElapsed":3, "secElapsed":38, "minLeft":16, "secLeft":22, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#4 FRANSON" },' +
    '{ "period":2, "minElapsed":3, "secElapsed":40, "minLeft":16, "secLeft":20, "type":"GOAL", "strength":"EV", "team":"TOR", "scorer":"#39 FRATTIN(2)", "assist_1st":"#4 FRANSON(2)", "assist_2nd":"#47 KOMAROV(1)" },' +
    '{ "period":2, "minElapsed":4, "secElapsed":52, "minLeft":15, "secLeft":8, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#29 POMINVILLE" },' +
    '{ "period":2, "minElapsed":5, "secElapsed":4, "minLeft":14, "secLeft":56, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#10 EHRHOFF" },' +
    '{ "period":2, "minElapsed":6, "secElapsed":21, "minLeft":13, "secLeft":39, "type":"GOAL", "strength":"EV", "team":"TOR", "scorer":"#4 FRANSON(1)", "assist_1st":"#81 KESSEL(3)", "assist_2nd":"#42 BOZAK(2)" },' +
    '{ "period":2, "minElapsed":8, "secElapsed":1, "minLeft":11, "secLeft":59, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":2, "minElapsed":9, "secElapsed":41, "minLeft":10, "secLeft":19, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#63 ENNIS" },' +
    '{ "period":2, "minElapsed":11, "secElapsed":7, "minLeft":8, "secLeft":53, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#82 FOLIGNO" },' +
    '{ "period":2, "minElapsed":12, "secElapsed":53, "minLeft":7, "secLeft":7, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#63 ENNIS" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":19, "minLeft":6, "secLeft":41, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#29 POMINVILLE" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":21, "minLeft":6, "secLeft":39, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#26 VANEK" },' +
    '{ "period":2, "minElapsed":16, "secElapsed":40, "minLeft":3, "secLeft":20, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#9 OTT" },' +
    '{ "period":2, "minElapsed":17, "secElapsed":37, "minLeft":2, "secLeft":23, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":2, "minElapsed":17, "secElapsed":45, "minLeft":2, "secLeft":15, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":2, "minElapsed":17, "secElapsed":46, "minLeft":2, "secLeft":14, "type":"PENL", "strength":"EV", "team":"BUF", "taker":"#55 HECHT", "reason":"Unsportsmanlike conduct(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":17, "secElapsed":46, "minLeft":2, "secLeft":14, "type":"PENL", "strength":"EV", "team":"BUF", "taker":"#55 HECHT", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"PEND", "strength":" " },' +
    '{ "period":3, "minElapsed":0, "secElapsed":0, "minLeft":20, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":3, "minElapsed":0, "secElapsed":27, "minLeft":19, "secLeft":33, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":3, "minElapsed":0, "secElapsed":30, "minLeft":19, "secLeft":30, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":3, "minElapsed":1, "secElapsed":19, "minLeft":18, "secLeft":41, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":3, "minElapsed":3, "secElapsed":13, "minLeft":16, "secLeft":47, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#63 ENNIS" },' +
    '{ "period":3, "minElapsed":6, "secElapsed":46, "minLeft":13, "secLeft":14, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":7, "minLeft":12, "secLeft":53, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#6 WEBER" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":10, "minLeft":12, "secLeft":50, "type":"GOAL", "strength":"EV", "team":"BUF", "scorer":"#25 GRIGORENKO(1)", "assist_1st":"#6 WEBER(1)", "assist_2nd":"#82 FOLIGNO(2)" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":23, "minLeft":12, "secLeft":37, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#10 EHRHOFF" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":54, "minLeft":12, "secLeft":6, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#84 GRABOVSKI" },' +
    '{ "period":3, "minElapsed":8, "secElapsed":22, "minLeft":11, "secLeft":38, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK" },' +
    '{ "period":3, "minElapsed":9, "secElapsed":54, "minLeft":10, "secLeft":6, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#9 OTT" },' +
    '{ "period":3, "minElapsed":10, "secElapsed":9, "minLeft":9, "secLeft":51, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#63 ENNIS" },' +
    '{ "period":3, "minElapsed":11, "secElapsed":58, "minLeft":8, "secLeft":2, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#19 HODGSON" },' +
    '{ "period":3, "minElapsed":12, "secElapsed":3, "minLeft":7, "secLeft":57, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#19 HODGSON" },' +
    '{ "period":3, "minElapsed":15, "secElapsed":57, "minLeft":4, "secLeft":3, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#57 MYERS" },' +
    '{ "period":3, "minElapsed":16, "secElapsed":24, "minLeft":3, "secLeft":36, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#11 MCCLEMENT" },' +
    '{ "period":3, "minElapsed":16, "secElapsed":29, "minLeft":3, "secLeft":31, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#11 MCCLEMENT" },' +
    '{ "period":3, "minElapsed":19, "secElapsed":15, "minLeft":0, "secLeft":45, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#37 ELLIS" },' +
    '{ "period":3, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"PEND", "strength":" " },' +
    '{ "period":4, "minElapsed":0, "secElapsed":0, "minLeft":5, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":4, "minElapsed":0, "secElapsed":29, "minLeft":4, "secLeft":31, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":4, "minElapsed":0, "secElapsed":44, "minLeft":4, "secLeft":16, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#26 VANEK" },' +
    '{ "period":4, "minElapsed":1, "secElapsed":7, "minLeft":3, "secLeft":53, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#24 LILES" },' +
    '{ "period":4, "minElapsed":2, "secElapsed":26, "minLeft":2, "secLeft":34, "type":"SHOT", "strength":"EV", "team":"BUF", "shooter":"#10 EHRHOFF" },' +
    '{ "period":4, "minElapsed":4, "secElapsed":58, "minLeft":0, "secLeft":2, "type":"GOAL", "strength":"EV", "team":"TOR", "scorer":"#39 FRATTIN(3)", "assist_1st":"#24 LILES(4)" },' +
    '{ "period":4, "minElapsed":4, "secElapsed":58, "minLeft":0, "secLeft":2, "type":"PEND", "strength":" " }' +
  ']';

  data += ',';

  data += '"teams": [' +
    '{ "type":"home", "name":"BUFFALO SABRES",      "abbreviation":"BUF" },' +
    '{ "type":"away", "name":"TORONTO MAPLE LEAFS", "abbreviation":"TOR" }' +
  ']';
*/

  data += ' }';

  return data;
}
