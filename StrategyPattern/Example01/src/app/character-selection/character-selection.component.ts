import { Component } from '@angular/core';
import {GameService} from "../service/game.service";
import {Character} from "../character/character";

@Component({
  selector: 'app-character-selection',
  templateUrl: './character-selection.component.html',
  styleUrls: ['./character-selection.component.scss']
})
export class CharacterSelectionComponent {

  constructor(public gameService: GameService) { }

  public onCharacterSelected(character: Character): void {

  }
}
