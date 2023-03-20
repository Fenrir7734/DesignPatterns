import {AttackStrategy} from "./attack/attack-strategy";

export abstract class Character {
  private life: number;
  private accuracy: number;
  private luck: number;

  public attackStrategy: AttackStrategy;

  protected constructor(
    life: number,
    accuracy: number,
    luck: number,
    attackStrategy: AttackStrategy) {

    this.life = life;
    this.accuracy = accuracy;
    this.luck = luck;
    this.attackStrategy = attackStrategy;
  }

  public abstract type(): string;

  public attack(): void {

  }

  public setAttackStrategy(attackStrategy: AttackStrategy): void {
    this.attackStrategy = attackStrategy;
  }
}
