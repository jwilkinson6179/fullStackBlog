import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-testposts',
  templateUrl: './testposts.component.html',
  styleUrls: ['./testposts.component.scss']
})
export class TestpostsComponent implements OnInit {

  counter = 0;
  constructor() {  }

  ngOnInit(): void {
  }

  onIncreaseCount(){
    this.counter++;
  }

}
