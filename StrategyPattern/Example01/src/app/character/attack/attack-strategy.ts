export interface AttackStrategy {
  attack(): void;
  type(): string;
}
