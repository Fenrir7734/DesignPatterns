import {AttackStrategy} from "./attack-strategy";

export class FireBallAttackStrategy implements AttackStrategy {
  public attack(): void {
  }

  public type(): string {
    return "Fireball";
  }
}
