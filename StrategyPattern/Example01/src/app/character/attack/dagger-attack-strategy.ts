import {AttackStrategy} from "./attack-strategy";

export class DaggerAttackStrategy implements AttackStrategy {
  public attack(): void {
  }

  public type(): string {
    return "Dagger";
  }
}
