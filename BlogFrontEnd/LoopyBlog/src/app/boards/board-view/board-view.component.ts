import {Component, OnDestroy, OnInit} from '@angular/core';
import {BoardService} from '../../services/board/board.service';
import {Subscription} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-board-view',
  templateUrl: './board-view.component.html',
  styleUrls: ['./board-view.component.scss']
})
export class BoardViewComponent implements OnInit, OnDestroy {

  board: any = {};
  posts: Array<any>;
  boards: Array<any>;
  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private boardService: BoardService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params.id;
      if (id) {
        this.boardService.get(id).subscribe((board: any) => {
          if (board) {
            this.posts = board.posts;
            this.board.href = board._links.self.href;
          } else {
            console.log(`Board with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }



  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/board-list']);
  }

}
