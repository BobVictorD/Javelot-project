import { Component, OnInit } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { ExerciceAlgoService } from 'src/app/services/exercice-algo.service';

@Component({
  selector: 'app-exercice-algo',
  templateUrl: './exercice-algo.component.html',
  styleUrls: ['./exercice-algo.component.css']
})
export class ExerciceAlgoComponent {

  hash$: Observable<number> = new Subject();
  value$: Observable<string> = new Subject();

  hash: number | undefined;
  value: string | undefined;

  letters = "abcdefghijklmnopqrstuvwxyz"

  constructor(private exerciceAlgoService: ExerciceAlgoService) {}


  encode() {
    if(this.value != undefined) {
      this.hash$ = this.exerciceAlgoService.encode$(this.value);
    }
  }

  decode() {
    if(this.hash != undefined) {
      this.value$ = this.exerciceAlgoService.decode$(this.hash);
    }
  }

  /*public encode()
  {
    if(this.value != undefined) {
      let hash: number = 26;
      for (let i = 0; i < this.value.length; i++)
      {
         hash = (hash * 37 + this.letters.indexOf(this.value.charAt(i)));
 
      }
      this.hash$.next(hash);
    }
  }

  public decode()
  {
    if(this.hash != undefined) {
      let todecode: number = this.hash;
      let value: string = "";
      while (todecode > 26)
      {
         const reste: number = todecode % 37;
         todecode = todecode / 37;
         value = this.letters.charAt(reste) + value
      }
      this.value$.next(value);
    }
    
  }*/

}
