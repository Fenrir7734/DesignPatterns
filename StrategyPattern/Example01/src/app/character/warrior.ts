import {Character} from "./character";
import {LongSwordAttackStrategy} from "./attack/long-sword-attack-strategy";

export class Warrior extends Character {
  constructor() {
    super(120, 60, 60, new LongSwordAttackStrategy());
  }

  public override type(): string {
    return "Warrior"
  }
}
