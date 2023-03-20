import { Injectable } from '@angular/core';
import {Character} from "../character/character";
import {Warrior} from "../character/warrior";
import {Rogue} from "../character/rogue";
import {Mage} from "../character/mage";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  public playableCharacters: Character[] = [
    new Warrior(),
    new Rogue(),
    new Mage()
  ];

  constructor() { }
}
