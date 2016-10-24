package com.deanveloper.derivativekt.expression.trigexpression

import com.deanveloper.derivativekt.defaultScale
import com.deanveloper.derivativekt.expression.Expression
import com.deanveloper.derivativekt.expression.Value
import com.deanveloper.derivativekt.expression.twopartexpression.MultiplicationExpression
import com.deanveloper.derivativekt.sin
import java.math.BigDecimal

/**
 * @author Dean
 */
class CotangentExpression(
        variables: CharArray,
        f: Expression,
        isNegative: Boolean = false
) : Expression.TrigExpression(variables, f, isNegative) {
    constructor(variable: Char,
                f: Expression,
                isNegative: Boolean = false
    ) : this(charArrayOf(variable), f, isNegative)

    override fun execute(args: Map<Char, Expression>): CotangentExpression {
        return CotangentExpression(vars, f.execute(args), isNegative)
    }

    override fun derive(variable: Char): Expression {
        return MultiplicationExpression(vars,
                MultiplicationExpression(vars,
                        -this,
                        CotangentExpression(vars, f, false)
                ),
                f.derive(variable)
        )
    }

    override fun simplify(): Expression {
        val simp = CotangentExpression(vars, f.simplify(), isNegative)
        with(simp) {
            if (f.isNegative) {
                return CotangentExpression(vars, -f, !isNegative).simplify()
            }

            if (f is Value) {
                return Value(BigDecimal.ONE.divide(f.value.sin(), defaultScale)).simplify()
            }

            return this
        }
    }

    override fun unaryMinus(): Expression {
        return CotangentExpression(vars, f, !isNegative)
    }

    override fun toString(): String {
        return "cot($f)"
    }
}