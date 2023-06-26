package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D
import java.util.concurrent.TimeUnit
import java.io.File

class Explosion(
  initialPosition: Point2D,
  initialVelocity: Vector2D,
  radius: Double,
  mass: Double
) :
  SpaceObject("Explosion", '*', initialPosition, initialVelocity, radius, mass) {

    var is_triggered: Boolean = true
      private set

    var score_from_explosion: Double = 0.0
      private set

    init {
      TimeUnit.MILLISECONDS.sleep(1000)
      is_triggered = false
      score_from_explosion = scoreExplosion()
    }

    private fun scoreExplosion(): Double {
      return (this.mass / this.radius) * 10
    }

  }