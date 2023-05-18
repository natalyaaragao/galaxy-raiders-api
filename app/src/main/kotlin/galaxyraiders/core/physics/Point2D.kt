package galaxyraiders.core.physics
import kotlin.math.*

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    return Point2D(x = p.x + this.x, y = p.y + this.y)
  }

  operator fun plus(v: Vector2D): Point2D {
    return Point2D(x = v.dx + this.x, y = v.dy + this.y)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(dx = this.x, dy = this.y)
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D(dx = abs(p.x - this.x), dy = abs(p.y - this.y))
  }

  fun impactDirection(p: Point2D): Vector2D {
    return Vector2D(dx = p.x - this.x, dy = p.y - this.y)
  }

  fun contactVector(p: Point2D): Vector2D {
    val impact_vector = impactVector(p)
    return Vector2D(dx = impact_vector.normal.dx, dy = impact_vector.normal.dy)
  }

  fun contactDirection(p: Point2D): Vector2D {
    val impact_direction = impactDirection(p)
    return Vector2D(dx = impact_direction.normal.dx, dy = impact_direction.normal.dy)
  }

  fun distance(p: Point2D): Double {
    val dist_x = this.x - p.x
    val dist_y = this.y - p.y
    return sqrt((dist_x * dist_x) + (dist_y * dist_y))
  }
}
