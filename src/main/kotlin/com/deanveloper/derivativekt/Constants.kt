package com.deanveloper.derivativekt

import java.math.BigDecimal

/**
 * The constant e
 */
private val _E = BigDecimal("""
2.7182818284590452353602874713526624977572470936999595749669676277240766303
535475945713821785251664274274663919320030599218174135966290435729003342952
605956307381323286279434907632338298807531952510190115738341879307021540891
499348841675092447614606680822648001684774118537423454424371075390777449920
695517027618386062613313845830007520449338265602976067371132007093287091274
437470472306969772093101416928368190255151086574637721112523897844250569536
967707854499699679468644549059879316368892300987931277361782154249992295763
514822082698951936680331825288693984964651058209392398294887933203625094431
173012381970684161403970198376793206832823764648042953118023287825098194558
153017567173613320698112509961818815930416903515988885193458072738667385894
""".replace(Regex("[\\D.]"), ""))

/**
 * The constant pi
 */
private val _PI = BigDecimal("""
3.1415926535897932384626433832795028841971693993751058209749445923078164062
862089986280348253421170679821480865132823066470938446095505822317253594081
284811174502841027019385211055596446229489549303819644288109756659334461284
756482337867831652712019091456485669234603486104543266482133936072602491412
737245870066063155881748815209209628292540917153643678925903600113305305488
204665213841469519415116094330572703657595919530921861173819326117931051185
480744623799627495673518857527248912279381830119491298336733624406566430860
213949463952247371907021798609437027705392171762931767523846748184676694051
320005681271452635608277857713427577896091736371787214684409012249534301465
495853710507922796892589235420199561121290219608640344181598136297747713099
""".replace(Regex("[\\D.]"), ""))

var E = _E.setScale(defaultScale)!!

var PI = _PI.setScale(defaultScale)!!

fun recalculateConstants() {
    E = _E.setScale(defaultScale)!!
    PI = _PI.setScale(defaultScale)!!
}