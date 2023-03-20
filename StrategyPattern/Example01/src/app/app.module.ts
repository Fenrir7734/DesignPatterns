import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CharacterSelectionComponent } from './character-selection/character-selection.component';
import { CharacterSelectComponent } from './character-selection/character-select/character-select.component';

@NgModule({
  declarations: [
    AppComponent,
    CharacterSelectionComponent,
    CharacterSelectComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
