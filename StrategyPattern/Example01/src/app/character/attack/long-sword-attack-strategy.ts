import {AttackStrategy} from "./attack-strategy";

export class LongSwordAttackStrategy implements AttackStrategy {
  public attack(): void {
  }

  public type(): string {
    return "Long sword";
  }
}
