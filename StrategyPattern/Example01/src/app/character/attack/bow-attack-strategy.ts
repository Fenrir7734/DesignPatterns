import {AttackStrategy} from "./attack-strategy";

export class BowAttackStrategy implements AttackStrategy {
  public attack(): void {
  }

  public type(): string {
    return "Bow";
  }
}
