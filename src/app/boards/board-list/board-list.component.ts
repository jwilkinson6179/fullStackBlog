import { Component, OnInit } from '@angular/core';
import {BoardService} from '../../services/board/board.service';

@Component({
  selector: 'app-board-list',
  templateUrl: './board-list.component.html',
  styleUrls: ['./board-list.component.scss']
})
export class BoardListComponent implements OnInit {

  boards: Array<any>;

  constructor(private boardService: BoardService) { }

  ngOnInit() {
    this.boardService.getBoards().subscribe(data => {
      this.boards = data;
    });
  }

}
