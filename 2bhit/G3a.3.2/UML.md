# UML-Diagramme vom Programm *G 3a.3.2: Dreieck mit Punkt2D-Objekten **

| Punkt2D                                                   |
| --------------------------------------------------------- |
| `- x: int`                                                |
| `- y: int`                                                |
|                                                           |
| `+ Punkt2D()`                                             |
| `+ Punkt2D(x_: int, y_: int)`                             |
| `+ getX(): int`                                           |
| `+ setX(x_: int): void`                                   |
| `+ getY(): int`                                           |
| `+ setY(y_: int): void`                                   |
| `+ textDaten(): String`                                   |
| `+ abstandNull(): double`                                 |
| `+ abstand(other: Punkt2D): double`                       |
| `+`<u>`abstand`</u>`(one: Punkt2D, two: Punkt2D): double` |
| `+ equals(other: Punkt2D): boolean`                       |

| Dreieck                                              |
| ---------------------------------------------------- |
| `- p1: Punkt2D`                                      |
| `- p2: Punkt2D`                                      |
| `- p3: Punkt2D`                                      |
|                                                      |
| `+ Dreieck()`                                        |
| `+ Dreieck(p1_: Punkt2D, p2: Punkt2D, p3_: Punkt2D)` |
| `+ setP1(p1_: Punkt2D): void`                        |
| `+ setP2(p2_: Punkt2D): void`                        |
| `+ setP3(p3_: Punkt2D): void`                        |
| `+ getP1(): Punkt2D`                                 |
| `+ getP2(): Punkt2D`                                 |
| `+ getP3(): Punkt2D`                                 |
| `+ toString(): String`                               |
| `+ umfang(): double`                                 |
| `+ equals(other: Dreieck): boolean`                  |

| Test                                                  |
| ----------------------------------------------------- |
| `+` <u>`erstellePunkt`</u>`(values: String): Punkt2D` |
| `+` <u>`main`</u>`(String[] args): void`              |

