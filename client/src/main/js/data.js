function getJsonData() {
  var data = '{ ';

  data += '"gameEvents": [' +
    '{ "period":1, "minElapsed":0, "secElapsed":0, "minLeft":20, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":1, "minElapsed":0, "secElapsed":46, "minLeft":19, "secLeft":14, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#79 MARKOV" },' +
    '{ "period":1, "minElapsed":0, "secElapsed":46, "minLeft":19, "secLeft":14, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#79 MARKOV" },' +
    '{ "period":1, "minElapsed":0, "secElapsed":50, "minLeft":19, "secLeft":10, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#14 PLEKANEC" },' +
    '{ "period":1, "minElapsed":0, "secElapsed":50, "minLeft":19, "secLeft":10, "type":"MISS", "strength":"EV", "team":"MTL", "shooter":"#14 PLEKANEC", "target":"Wide of Net" },' +
    '{ "period":1, "minElapsed":0, "secElapsed":59, "minLeft":19, "secLeft":1, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#47 KOMAROV" },' +
    '{ "period":1, "minElapsed":0, "secElapsed":59, "minLeft":19, "secLeft":1, "type":"GOAL", "strength":"EV", "team":"TOR", "shooter":"#47 KOMAROV", "goalCount":"(1)", "assist1st":"#41 KULEMIN", "assist1stCount":"(6)" },' +
    '{ "period":1, "minElapsed":1, "secElapsed":31, "minLeft":18, "secLeft":29, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":1, "minElapsed":1, "secElapsed":31, "minLeft":18, "secLeft":29, "type":"MISS", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL", "target":"Wide of Net" },' +
    '{ "period":1, "minElapsed":2, "secElapsed":26, "minLeft":17, "secLeft":34, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":1, "minElapsed":2, "secElapsed":26, "minLeft":17, "secLeft":34, "type":"MISS", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR", "target":"Goalpost" },' +
    '{ "period":1, "minElapsed":3, "secElapsed":19, "minLeft":16, "secLeft":41, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":1, "minElapsed":3, "secElapsed":19, "minLeft":16, "secLeft":41, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":1, "minElapsed":4, "secElapsed":14, "minLeft":15, "secLeft":46, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#84 GRABOVSKI" },' +
    '{ "period":1, "minElapsed":4, "secElapsed":14, "minLeft":15, "secLeft":46, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#84 GRABOVSKI" },' +
    '{ "period":1, "minElapsed":4, "secElapsed":52, "minLeft":15, "secLeft":8, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":1, "minElapsed":4, "secElapsed":52, "minLeft":15, "secLeft":8, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":1, "minElapsed":5, "secElapsed":55, "minLeft":14, "secLeft":5, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#17 BOURQUE" },' +
    '{ "period":1, "minElapsed":5, "secElapsed":55, "minLeft":14, "secLeft":5, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#17 BOURQUE" },' +
    '{ "period":1, "minElapsed":6, "secElapsed":24, "minLeft":13, "secLeft":36, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":1, "minElapsed":6, "secElapsed":24, "minLeft":13, "secLeft":36, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":1, "minElapsed":6, "secElapsed":30, "minLeft":13, "secLeft":30, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":6, "secElapsed":30, "minLeft":13, "secLeft":30, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":6, "secElapsed":33, "minLeft":13, "secLeft":27, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK" },' +
    '{ "period":1, "minElapsed":6, "secElapsed":33, "minLeft":13, "secLeft":27, "type":"GOAL", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK", "goalCount":"(4)", "assist1st":"#21 VAN RIEMSDYK", "assist1stCount":"(2)", "assist2nd":"#24 LILES", "assist2ndCount":"(5)" },' +
    '{ "period":1, "minElapsed":7, "secElapsed":32, "minLeft":12, "secLeft":28, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":1, "minElapsed":7, "secElapsed":32, "minLeft":12, "secLeft":28, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":1, "minElapsed":7, "secElapsed":46, "minLeft":12, "secLeft":14, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":1, "minElapsed":7, "secElapsed":46, "minLeft":12, "secLeft":14, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":1, "minElapsed":8, "secElapsed":52, "minLeft":11, "secLeft":8, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":1, "minElapsed":8, "secElapsed":52, "minLeft":11, "secLeft":8, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#53 KOSTKA" },' +
    '{ "period":1, "minElapsed":9, "secElapsed":38, "minLeft":10, "secLeft":22, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":9, "secElapsed":38, "minLeft":10, "secLeft":22, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":12, "secElapsed":27, "minLeft":7, "secLeft":33, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#61 DIAZ" },' +
    '{ "period":1, "minElapsed":12, "secElapsed":27, "minLeft":7, "secLeft":33, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#61 DIAZ" },' +
    '{ "period":1, "minElapsed":13, "secElapsed":22, "minLeft":6, "secLeft":38, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":1, "minElapsed":13, "secElapsed":22, "minLeft":6, "secLeft":38, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":1, "minElapsed":13, "secElapsed":47, "minLeft":6, "secLeft":13, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#55 BOUILLON" },' +
    '{ "period":1, "minElapsed":13, "secElapsed":47, "minLeft":6, "secLeft":13, "type":"MISS", "strength":"EV", "team":"MTL", "shooter":"#55 BOUILLON", "target":"Goalpost" },' +
    '{ "period":1, "minElapsed":14, "secElapsed":53, "minLeft":5, "secLeft":7, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":1, "minElapsed":14, "secElapsed":53, "minLeft":5, "secLeft":7, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":1, "minElapsed":15, "secElapsed":44, "minLeft":4, "secLeft":16, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":15, "secElapsed":44, "minLeft":4, "secLeft":16, "type":"MISS", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK", "target":"Wide of Net" },' +
    '{ "period":1, "minElapsed":16, "secElapsed":6, "minLeft":3, "secLeft":54, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":1, "minElapsed":16, "secElapsed":6, "minLeft":3, "secLeft":54, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":1, "minElapsed":16, "secElapsed":11, "minLeft":3, "secLeft":49, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#81 ELLER" },' +
    '{ "period":1, "minElapsed":16, "secElapsed":11, "minLeft":3, "secLeft":49, "type":"MISS", "strength":"EV", "team":"MTL", "shooter":"#81 ELLER", "target":"Wide of Net" },' +
    '{ "period":1, "minElapsed":17, "secElapsed":28, "minLeft":2, "secLeft":32, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#14 PLEKANEC" },' +
    '{ "period":1, "minElapsed":17, "secElapsed":28, "minLeft":2, "secLeft":32, "type":"MISS", "strength":"EV", "team":"MTL", "shooter":"#14 PLEKANEC", "target":"Over Net" },' +
    '{ "period":1, "minElapsed":18, "secElapsed":56, "minLeft":1, "secLeft":4, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":18, "secElapsed":56, "minLeft":1, "secLeft":4, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":1, "minElapsed":19, "secElapsed":14, "minLeft":0, "secLeft":46, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":1, "minElapsed":19, "secElapsed":14, "minLeft":0, "secLeft":46, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":1, "minElapsed":19, "secElapsed":49, "minLeft":0, "secLeft":11, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#76 SUBBAN" },' +
    '{ "period":1, "minElapsed":19, "secElapsed":49, "minLeft":0, "secLeft":11, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#76 SUBBAN" },' +
    '{ "period":1, "minElapsed":19, "secElapsed":52, "minLeft":0, "secLeft":8, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#55 HOLZER", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":1, "minElapsed":19, "secElapsed":52, "minLeft":0, "secLeft":8, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#51 DESHARNAIS", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":1, "minElapsed":19, "secElapsed":59, "minLeft":0, "secLeft":1, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#21 GIONTA" },' +
    '{ "period":1, "minElapsed":19, "secElapsed":59, "minLeft":0, "secLeft":1, "type":"MISS", "strength":"EV", "team":"MTL", "shooter":"#21 GIONTA", "target":"Over Net" },' +
    '{ "period":1, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"PEND", "strength":" " },' +
    '{ "period":2, "minElapsed":0, "secElapsed":0, "minLeft":20, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":2, "minElapsed":0, "secElapsed":23, "minLeft":19, "secLeft":37, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#14 PLEKANEC" },' +
    '{ "period":2, "minElapsed":0, "secElapsed":23, "minLeft":19, "secLeft":37, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#14 PLEKANEC" },' +
    '{ "period":2, "minElapsed":0, "secElapsed":33, "minLeft":19, "secLeft":27, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#61 DIAZ" },' +
    '{ "period":2, "minElapsed":0, "secElapsed":33, "minLeft":19, "secLeft":27, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#61 DIAZ" },' +
    '{ "period":2, "minElapsed":0, "secElapsed":37, "minLeft":19, "secLeft":23, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#81 ELLER" },' +
    '{ "period":2, "minElapsed":0, "secElapsed":37, "minLeft":19, "secLeft":23, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#81 ELLER" },' +
    '{ "period":2, "minElapsed":1, "secElapsed":16, "minLeft":18, "secLeft":44, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":2, "minElapsed":1, "secElapsed":16, "minLeft":18, "secLeft":44, "type":"MISS", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY", "target":"Over Net" },' +
    '{ "period":2, "minElapsed":1, "secElapsed":48, "minLeft":18, "secLeft":12, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#74 EMELIN" },' +
    '{ "period":2, "minElapsed":1, "secElapsed":48, "minLeft":18, "secLeft":12, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#74 EMELIN" },' +
    '{ "period":2, "minElapsed":2, "secElapsed":47, "minLeft":17, "secLeft":13, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK" },' +
    '{ "period":2, "minElapsed":2, "secElapsed":47, "minLeft":17, "secLeft":13, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK" },' +
    '{ "period":2, "minElapsed":2, "secElapsed":53, "minLeft":17, "secLeft":7, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":2, "minElapsed":2, "secElapsed":53, "minLeft":17, "secLeft":7, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":2, "minElapsed":3, "secElapsed":36, "minLeft":16, "secLeft":24, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK" },' +
    '{ "period":2, "minElapsed":3, "secElapsed":36, "minLeft":16, "secLeft":24, "type":"GOAL", "strength":"EV", "team":"TOR", "shooter":"#21 VAN RIEMSDYK", "goalCount":"(7)", "assist1st":"#81 KESSEL", "assist1stCount":"(7)" },' +
    '{ "period":2, "minElapsed":4, "secElapsed":26, "minLeft":15, "secLeft":34, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#72 COLE", "reason":"Slashing(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":5, "secElapsed":20, "minLeft":14, "secLeft":40, "type":"GATT", "strength":"SH", "team":"MTL", "shooter":"#14 PLEKANEC" },' +
    '{ "period":2, "minElapsed":5, "secElapsed":20, "minLeft":14, "secLeft":40, "type":"SHOT", "strength":"SH", "team":"MTL", "shooter":"#14 PLEKANEC" },' +
    '{ "period":2, "minElapsed":6, "secElapsed":49, "minLeft":13, "secLeft":11, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#72 COLE" },' +
    '{ "period":2, "minElapsed":6, "secElapsed":49, "minLeft":13, "secLeft":11, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#72 COLE" },' +
    '{ "period":2, "minElapsed":7, "secElapsed":22, "minLeft":12, "secLeft":38, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#14 PLEKANEC" },' +
    '{ "period":2, "minElapsed":7, "secElapsed":22, "minLeft":12, "secLeft":38, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#14 PLEKANEC" },' +
    '{ "period":2, "minElapsed":7, "secElapsed":57, "minLeft":12, "secLeft":3, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":2, "minElapsed":7, "secElapsed":57, "minLeft":12, "secLeft":3, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":2, "minElapsed":8, "secElapsed":37, "minLeft":11, "secLeft":23, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK" },' +
    '{ "period":2, "minElapsed":8, "secElapsed":37, "minLeft":11, "secLeft":23, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#42 BOZAK" },' +
    '{ "period":2, "minElapsed":8, "secElapsed":52, "minLeft":11, "secLeft":8, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":2, "minElapsed":8, "secElapsed":52, "minLeft":11, "secLeft":8, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":2, "minElapsed":9, "secElapsed":1, "minLeft":10, "secLeft":59, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#39 FRATTIN" },' +
    '{ "period":2, "minElapsed":9, "secElapsed":1, "minLeft":10, "secLeft":59, "type":"MISS", "strength":"EV", "team":"TOR", "shooter":"#39 FRATTIN", "target":"Wide of Net" },' +
    '{ "period":2, "minElapsed":9, "secElapsed":1, "minLeft":10, "secLeft":59, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#73 GALLAGHER", "reason":"Diving(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":9, "secElapsed":14, "minLeft":10, "secLeft":46, "type":"GATT", "strength":"PP", "team":"TOR", "shooter":"#39 FRATTIN" },' +
    '{ "period":2, "minElapsed":9, "secElapsed":14, "minLeft":10, "secLeft":46, "type":"MISS", "strength":"PP", "team":"TOR", "shooter":"#39 FRATTIN", "target":"Wide of Net" },' +
    '{ "period":2, "minElapsed":9, "secElapsed":40, "minLeft":10, "secLeft":20, "type":"GATT", "strength":"PP", "team":"TOR", "shooter":"#39 FRATTIN" },' +
    '{ "period":2, "minElapsed":9, "secElapsed":40, "minLeft":10, "secLeft":20, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#39 FRATTIN" },' +
    '{ "period":2, "minElapsed":10, "secElapsed":37, "minLeft":9, "secLeft":23, "type":"PENL", "strength":"PP", "team":"TOR", "taker":"#3 PHANEUF", "reason":"Interference(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":10, "secElapsed":37, "minLeft":9, "secLeft":23, "type":"PENL", "strength":"SH", "team":"MTL", "taker":"#8 PRUST", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":11, "secElapsed":29, "minLeft":8, "secLeft":31, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#45 FRASER", "reason":"Delaying Game-Puck over glass(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":12, "secElapsed":7, "minLeft":7, "secLeft":53, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#79 MARKOV" },' +
    '{ "period":2, "minElapsed":12, "secElapsed":7, "minLeft":7, "secLeft":53, "type":"MISS", "strength":"PP", "team":"MTL", "shooter":"#79 MARKOV", "target":"Wide of Net" },' +
    '{ "period":2, "minElapsed":12, "secElapsed":22, "minLeft":7, "secLeft":38, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#76 SUBBAN" },' +
    '{ "period":2, "minElapsed":12, "secElapsed":22, "minLeft":7, "secLeft":38, "type":"MISS", "strength":"PP", "team":"MTL", "shooter":"#76 SUBBAN", "target":"Wide of Net" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":21, "minLeft":6, "secLeft":39, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#61 DIAZ" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":21, "minLeft":6, "secLeft":39, "type":"SHOT", "strength":"PP", "team":"MTL", "shooter":"#61 DIAZ" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":23, "minLeft":6, "secLeft":37, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":23, "minLeft":6, "secLeft":37, "type":"SHOT", "strength":"PP", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":28, "minLeft":6, "secLeft":32, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#27 GALCHENYUK" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":28, "minLeft":6, "secLeft":32, "type":"SHOT", "strength":"PP", "team":"MTL", "shooter":"#27 GALCHENYUK" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":37, "minLeft":6, "secLeft":23, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#72 COLE" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":37, "minLeft":6, "secLeft":23, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#72 COLE" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":41, "minLeft":6, "secLeft":19, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#72 COLE" },' +
    '{ "period":2, "minElapsed":13, "secElapsed":41, "minLeft":6, "secLeft":19, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#72 COLE" },' +
    '{ "period":2, "minElapsed":14, "secElapsed":16, "minLeft":5, "secLeft":44, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#74 EMELIN" },' +
    '{ "period":2, "minElapsed":14, "secElapsed":16, "minLeft":5, "secLeft":44, "type":"MISS", "strength":"EV", "team":"MTL", "shooter":"#74 EMELIN", "target":"Over Net" },' +
    '{ "period":2, "minElapsed":14, "secElapsed":23, "minLeft":5, "secLeft":37, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#21 GIONTA" },' +
    '{ "period":2, "minElapsed":14, "secElapsed":23, "minLeft":5, "secLeft":37, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#21 GIONTA" },' +
    '{ "period":2, "minElapsed":14, "secElapsed":45, "minLeft":5, "secLeft":15, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":2, "minElapsed":14, "secElapsed":45, "minLeft":5, "secLeft":15, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":2, "minElapsed":15, "secElapsed":11, "minLeft":4, "secLeft":49, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#47 KOMAROV" },' +
    '{ "period":2, "minElapsed":15, "secElapsed":11, "minLeft":4, "secLeft":49, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#47 KOMAROV" },' +
    '{ "period":2, "minElapsed":15, "secElapsed":31, "minLeft":4, "secLeft":29, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#41 KULEMIN", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":15, "secElapsed":31, "minLeft":4, "secLeft":29, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#79 MARKOV", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":15, "secElapsed":44, "minLeft":4, "secLeft":16, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#3 PHANEUF" },' +
    '{ "period":2, "minElapsed":15, "secElapsed":44, "minLeft":4, "secLeft":16, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#3 PHANEUF" },' +
    '{ "period":2, "minElapsed":16, "secElapsed":2, "minLeft":3, "secLeft":58, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#27 GALCHENYUK" },' +
    '{ "period":2, "minElapsed":16, "secElapsed":2, "minLeft":3, "secLeft":58, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#27 GALCHENYUK" },' +
    '{ "period":2, "minElapsed":16, "secElapsed":48, "minLeft":3, "secLeft":12, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":2, "minElapsed":16, "secElapsed":48, "minLeft":3, "secLeft":12, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#67 PACIORETTY" },' +
    '{ "period":2, "minElapsed":17, "secElapsed":42, "minLeft":2, "secLeft":18, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#17 BOURQUE", "reason":"Hi-sticking(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":18, "secElapsed":1, "minLeft":1, "secLeft":59, "type":"GATT", "strength":"PP", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":2, "minElapsed":18, "secElapsed":1, "minLeft":1, "secLeft":59, "type":"GOAL", "strength":"PP", "team":"TOR", "shooter":"#81 KESSEL", "goalCount":"(2)", "assist1st":"#3 PHANEUF", "assist1stCount":"(2)", "assist2nd":"#4 FRANSON", "assist2ndCount":"(5)" },' +
    '{ "period":2, "minElapsed":18, "secElapsed":34, "minLeft":1, "secLeft":26, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#53 KOSTKA", "reason":"Holding(2 min)", "duration":2 },' +
    '{ "period":2, "minElapsed":19, "secElapsed":27, "minLeft":0, "secLeft":33, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#17 BOURQUE" },' +
    '{ "period":2, "minElapsed":19, "secElapsed":27, "minLeft":0, "secLeft":33, "type":"MISS", "strength":"PP", "team":"MTL", "shooter":"#17 BOURQUE", "target":"Wide of Net" },' +
    '{ "period":2, "minElapsed":19, "secElapsed":33, "minLeft":0, "secLeft":27, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#76 SUBBAN" },' +
    '{ "period":2, "minElapsed":19, "secElapsed":33, "minLeft":0, "secLeft":27, "type":"SHOT", "strength":"PP", "team":"MTL", "shooter":"#76 SUBBAN" },' +
    '{ "period":2, "minElapsed":19, "secElapsed":56, "minLeft":0, "secLeft":4, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#79 MARKOV" },' +
    '{ "period":2, "minElapsed":19, "secElapsed":56, "minLeft":0, "secLeft":4, "type":"SHOT", "strength":"PP", "team":"MTL", "shooter":"#79 MARKOV" },' +
    '{ "period":2, "minElapsed":19, "secElapsed":59, "minLeft":0, "secLeft":1, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":2, "minElapsed":19, "secElapsed":59, "minLeft":0, "secLeft":1, "type":"MISS", "strength":"PP", "team":"MTL", "shooter":"#73 GALLAGHER", "target":"Over Net" },' +
    '{ "period":2, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"PEND", "strength":" " },' +
    '{ "period":3, "minElapsed":0, "secElapsed":0, "minLeft":20, "secLeft":0, "type":"PSTR", "strength":" " },' +
    '{ "period":3, "minElapsed":1, "secElapsed":9, "minLeft":18, "secLeft":51, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#45 FRASER", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":3, "minElapsed":1, "secElapsed":9, "minLeft":18, "secLeft":51, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#8 PRUST", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":3, "minElapsed":1, "secElapsed":38, "minLeft":18, "secLeft":22, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#26 GORGES" },' +
    '{ "period":3, "minElapsed":1, "secElapsed":38, "minLeft":18, "secLeft":22, "type":"MISS", "strength":"EV", "team":"MTL", "shooter":"#26 GORGES", "target":"Wide of Net" },' +
    '{ "period":3, "minElapsed":2, "secElapsed":26, "minLeft":17, "secLeft":34, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#20 ARMSTRONG" },' +
    '{ "period":3, "minElapsed":2, "secElapsed":26, "minLeft":17, "secLeft":34, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#20 ARMSTRONG" },' +
    '{ "period":3, "minElapsed":3, "secElapsed":4, "minLeft":16, "secLeft":56, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#24 LILES" },' +
    '{ "period":3, "minElapsed":3, "secElapsed":4, "minLeft":16, "secLeft":56, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#24 LILES" },' +
    '{ "period":3, "minElapsed":3, "secElapsed":56, "minLeft":16, "secLeft":4, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":3, "minElapsed":3, "secElapsed":56, "minLeft":16, "secLeft":4, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#43 KADRI" },' +
    '{ "period":3, "minElapsed":3, "secElapsed":59, "minLeft":16, "secLeft":1, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#39 FRATTIN" },' +
    '{ "period":3, "minElapsed":3, "secElapsed":59, "minLeft":16, "secLeft":1, "type":"MISS", "strength":"EV", "team":"TOR", "shooter":"#39 FRATTIN", "target":"Wide of Net" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":1, "minLeft":15, "secLeft":59, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":1, "minLeft":15, "secLeft":59, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":14, "minLeft":15, "secLeft":46, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":14, "minLeft":15, "secLeft":46, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":18, "minLeft":15, "secLeft":42, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#28 ORR" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":18, "minLeft":15, "secLeft":42, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#28 ORR" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":20, "minLeft":15, "secLeft":40, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#55 HOLZER" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":20, "minLeft":15, "secLeft":40, "type":"GOAL", "strength":"EV", "team":"TOR", "shooter":"#55 HOLZER", "goalCount":"(2)", "assist1st":"#28 ORR", "assist1stCount":"(1)", "assist2nd":"#11 MCCLEMENT", "assist2ndCount":"(2)" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":30, "minLeft":15, "secLeft":30, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#32 MOEN" },' +
    '{ "period":3, "minElapsed":4, "secElapsed":30, "minLeft":15, "secLeft":30, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#32 MOEN" },' +
    '{ "period":3, "minElapsed":5, "secElapsed":52, "minLeft":14, "secLeft":8, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":3, "minElapsed":5, "secElapsed":52, "minLeft":14, "secLeft":8, "type":"MISS", "strength":"EV", "team":"TOR", "shooter":"#81 KESSEL", "target":"Hit Crossbar" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":6, "minLeft":12, "secLeft":54, "type":"GATT", "strength":"EV", "team":"TOR", "shooter":"#41 KULEMIN" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":6, "minLeft":12, "secLeft":54, "type":"SHOT", "strength":"EV", "team":"TOR", "shooter":"#41 KULEMIN" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":32, "minLeft":12, "secLeft":28, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":32, "minLeft":12, "secLeft":28, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#73 GALLAGHER" },' +
    '{ "period":3, "minElapsed":7, "secElapsed":59, "minLeft":12, "secLeft":1, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#53 KOSTKA", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":3, "minElapsed":7, "secElapsed":59, "minLeft":12, "secLeft":1, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#73 GALLAGHER", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":3, "minElapsed":7, "secElapsed":59, "minLeft":12, "secLeft":1, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#73 GALLAGHER", "reason":"Interference(2 min)", "duration":2 },' +
    '{ "period":3, "minElapsed":9, "secElapsed":28, "minLeft":10, "secLeft":32, "type":"GATT", "strength":"SH", "team":"MTL", "shooter":"#20 ARMSTRONG" },' +
    '{ "period":3, "minElapsed":9, "secElapsed":28, "minLeft":10, "secLeft":32, "type":"SHOT", "strength":"SH", "team":"MTL", "shooter":"#20 ARMSTRONG" },' +
    '{ "period":3, "minElapsed":11, "secElapsed":30, "minLeft":8, "secLeft":30, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#8 PRUST", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":3, "minElapsed":11, "secElapsed":30, "minLeft":8, "secLeft":30, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#8 PRUST", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":3, "minElapsed":11, "secElapsed":30, "minLeft":8, "secLeft":30, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#8 PRUST", "reason":"Misconduct (10 min)(10 min)", "duration":10 },' +
    '{ "period":3, "minElapsed":11, "secElapsed":30, "minLeft":8, "secLeft":30, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#84 GRABOVSKI", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":3, "minElapsed":11, "secElapsed":30, "minLeft":8, "secLeft":30, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#84 GRABOVSKI", "reason":"Misconduct (10 min)(10 min)", "duration":10 },' +
    '{ "period":3, "minElapsed":11, "secElapsed":30, "minLeft":8, "secLeft":30, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#67 PACIORETTY", "reason":"Misconduct (10 min)(10 min)", "duration":10 },' +
    '{ "period":3, "minElapsed":12, "secElapsed":17, "minLeft":7, "secLeft":43, "type":"PENL", "strength":"SH", "team":"MTL", "taker":"#14 PLEKANEC", "reason":"Holding(2 min)", "duration":2 },' +
    '{ "period":3, "minElapsed":12, "secElapsed":27, "minLeft":7, "secLeft":33, "type":"GATT", "strength":"PP", "team":"TOR", "shooter":"#81 KESSEL" },' +
    '{ "period":3, "minElapsed":12, "secElapsed":27, "minLeft":7, "secLeft":33, "type":"MISS", "strength":"PP", "team":"TOR", "shooter":"#81 KESSEL", "target":"Over Net" },' +
    '{ "period":3, "minElapsed":13, "secElapsed":15, "minLeft":6, "secLeft":45, "type":"GATT", "strength":"PP", "team":"TOR", "shooter":"#3 PHANEUF" },' +
    '{ "period":3, "minElapsed":13, "secElapsed":15, "minLeft":6, "secLeft":45, "type":"GOAL", "strength":"PP", "team":"TOR", "shooter":"#3 PHANEUF", "goalCount":"(1)", "assist1st":"#81 KESSEL", "assist1stCount":"(8)" },' +
    '{ "period":3, "minElapsed":14, "secElapsed":12, "minLeft":5, "secLeft":48, "type":"GATT", "strength":"PP", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":3, "minElapsed":14, "secElapsed":12, "minLeft":5, "secLeft":48, "type":"SHOT", "strength":"PP", "team":"TOR", "shooter":"#16 MACARTHUR" },' +
    '{ "period":3, "minElapsed":14, "secElapsed":17, "minLeft":5, "secLeft":43, "type":"GATT", "strength":"PP", "team":"TOR", "shooter":"#45 FRASER" },' +
    '{ "period":3, "minElapsed":14, "secElapsed":17, "minLeft":5, "secLeft":43, "type":"MISS", "strength":"PP", "team":"TOR", "shooter":"#45 FRASER", "target":"Wide of Net" },' +
    '{ "period":3, "minElapsed":15, "secElapsed":1, "minLeft":4, "secLeft":59, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#26 GORGES", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":3, "minElapsed":15, "secElapsed":1, "minLeft":4, "secLeft":59, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#38 MCLAREN", "reason":"Fighting (maj)(5 min)", "duration":5 },' +
    '{ "period":3, "minElapsed":15, "secElapsed":1, "minLeft":4, "secLeft":59, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#28 ORR", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":3, "minElapsed":15, "secElapsed":1, "minLeft":4, "secLeft":59, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#28 ORR", "reason":"Roughing(2 min)", "duration":2 },' +
    '{ "period":3, "minElapsed":15, "secElapsed":1, "minLeft":4, "secLeft":59, "type":"PENL", "strength":"EV", "team":"TOR", "taker":"#28 ORR", "reason":"Misconduct (10 min)(10 min)", "duration":10 },' +
    '{ "period":3, "minElapsed":15, "secElapsed":21, "minLeft":4, "secLeft":39, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#76 SUBBAN" },' +
    '{ "period":3, "minElapsed":15, "secElapsed":21, "minLeft":4, "secLeft":39, "type":"MISS", "strength":"PP", "team":"MTL", "shooter":"#76 SUBBAN", "target":"Wide of Net" },' +
    '{ "period":3, "minElapsed":15, "secElapsed":52, "minLeft":4, "secLeft":8, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#76 SUBBAN" },' +
    '{ "period":3, "minElapsed":15, "secElapsed":52, "minLeft":4, "secLeft":8, "type":"SHOT", "strength":"PP", "team":"MTL", "shooter":"#76 SUBBAN" },' +
    '{ "period":3, "minElapsed":16, "secElapsed":6, "minLeft":3, "secLeft":54, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#79 MARKOV" },' +
    '{ "period":3, "minElapsed":16, "secElapsed":6, "minLeft":3, "secLeft":54, "type":"SHOT", "strength":"PP", "team":"MTL", "shooter":"#79 MARKOV" },' +
    '{ "period":3, "minElapsed":17, "secElapsed":27, "minLeft":2, "secLeft":33, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#61 DIAZ" },' +
    '{ "period":3, "minElapsed":17, "secElapsed":27, "minLeft":2, "secLeft":33, "type":"SHOT", "strength":"PP", "team":"MTL", "shooter":"#61 DIAZ" },' +
    '{ "period":3, "minElapsed":18, "secElapsed":59, "minLeft":1, "secLeft":1, "type":"GATT", "strength":"PP", "team":"MTL", "shooter":"#21 GIONTA" },' +
    '{ "period":3, "minElapsed":18, "secElapsed":59, "minLeft":1, "secLeft":1, "type":"MISS", "strength":"PP", "team":"MTL", "shooter":"#21 GIONTA", "target":"Wide of Net" },' +
    '{ "period":3, "minElapsed":19, "secElapsed":14, "minLeft":0, "secLeft":46, "type":"PENL", "strength":"EV", "team":"MTL", "taker":"#17 BOURQUE", "reason":"Misconduct (10 min)(10 min)", "duration":10 },' +
    '{ "period":3, "minElapsed":19, "secElapsed":58, "minLeft":0, "secLeft":2, "type":"GATT", "strength":"EV", "team":"MTL", "shooter":"#81 ELLER" },' +
    '{ "period":3, "minElapsed":19, "secElapsed":58, "minLeft":0, "secLeft":2, "type":"SHOT", "strength":"EV", "team":"MTL", "shooter":"#81 ELLER" },' +
    '{ "period":3, "minElapsed":20, "secElapsed":0, "minLeft":0, "secLeft":0, "type":"PEND", "strength":" " }' +
  ']';

  data += ',';

  data += '"teams": [' +
    '{ "type":"home", "name":"TORONTO MAPLE LEAFS", "abbreviation":"TOR" },' +
    '{ "type":"away", "name":"MONTREAL CANADIENS", "abbreviation":"MTL" }' +
  ']';

  data += ' }';

  return data;
}
