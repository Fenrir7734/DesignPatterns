import {Character} from "./character";
import {DaggerAttackStrategy} from "./attack/dagger-attack-strategy";

export class Rogue extends Character {
  constructor() {
    super(80, 120, 80, new DaggerAttackStrategy());
  }

  public override type(): string {
    return "Rouge"
  }
}
