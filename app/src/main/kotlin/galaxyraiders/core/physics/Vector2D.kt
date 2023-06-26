package galaxyraiders.core.physics
import kotlin.math.*

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("unit", "normal", "degree", "magnitude")
data class Vector2D(val dx: Double, val dy: Double) {
  override fun toString(): String {
    return "Vector2D(dx=$dx, dy=$dy)"
  }

  val magnitude: Double
    get() = sqrt((this.dx*this.dx) + (this.dy*this.dy))

  val radiant: Double
    get() = atan2(this.dy, this.dx)

  val degree: Double
    get() = this.radiant * 180 / PI

  val unit: Vector2D
    get() = Vector2D(dx = this.dx / this.magnitude, dy = this.dy / this.magnitude)

  val normal: Vector2D
    get() = Vector2D(dx = this.dy, dy = - this.dx).unit

  operator fun times(scalar: Double): Vector2D {
    return Vector2D(dx = this.dx * scalar, dy = this.dy * scalar)
  }

  operator fun div(scalar: Double): Vector2D {
    return Vector2D(dx = this.dx / scalar, dy = this.dy / scalar)
  }

  operator fun times(v: Vector2D): Double {
    return (this.dx * v.dx) + (this.dy * v.dy)
  }

  operator fun plus(v: Vector2D): Vector2D {
    return Vector2D(dx = v.dx + this.dx, dy = v.dy + this.dy)
  }

  operator fun plus(p: Point2D): Point2D {
    return Point2D(x = this.dx + p.x, y = this.dy + p.y)
  }

  operator fun unaryMinus(): Vector2D {
    return Vector2D(dx = -1 * this.dx, dy = -1 * this.dy)
  }

  operator fun minus(v: Vector2D): Vector2D {
    return Vector2D(dx = this.dx - v.dx, dy = this.dy - v.dy)
  }

  fun scalarProject(target: Vector2D): Double {
    return (this.dx * target.unit.dx) + (this.dy * target.unit.dy) 
  }

  fun vectorProject(target: Vector2D): Vector2D {
    return (target.unit * scalarProject(target))
  }
}

operator fun Double.times(v: Vector2D): Vector2D {
  return (v * this)
}
