import {AttackStrategy} from "./attack-strategy";

export class ShortSwordAttackStrategy implements AttackStrategy {
  public attack(): void {
  }

  public type(): string {
    return "Short sword";
  }
}
