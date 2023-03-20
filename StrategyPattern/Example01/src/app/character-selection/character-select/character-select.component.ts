import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Character} from "../../character/character";

@Component({
  selector: 'app-character-select',
  templateUrl: './character-select.component.html',
  styleUrls: ['./character-select.component.scss']
})
export class CharacterSelectComponent {
  @Input() character: Character | undefined;

  @Output() selected: EventEmitter<Character> = new EventEmitter<Character>();

  public getImg(): string {
    return `assets/img/${this.character?.type()}.png`;
  }

  public onClick(): void {
    this.selected.emit(this.character);
  }
}
