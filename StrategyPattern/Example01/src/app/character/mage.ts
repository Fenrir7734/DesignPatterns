import { Character } from "./character";
import {FireBallAttackStrategy} from "./attack/fire-ball-attack-strategy";

export class Mage extends Character {
  constructor() {
    super(60, 80, 80, new FireBallAttackStrategy());
  }

  public override type(): string {
    return "Mage";
  }
}
