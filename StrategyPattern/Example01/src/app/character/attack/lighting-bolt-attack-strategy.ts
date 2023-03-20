import {AttackStrategy} from "./attack-strategy";

export class LightingBoltAttackStrategy implements AttackStrategy {
  public attack(): void {

  }

  public type(): string {
    return "Lighting bolt";
  }
}
