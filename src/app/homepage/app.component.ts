import {Component, OnInit} from '@angular/core';
import {PostService} from '../services/post/post.service';
import {BoardService} from '../services/board/board.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent  implements OnInit
{
  title = 'LoopyBlog';
  postData;
  boardData;
  constructor(private postService: PostService, private boardService: BoardService) {

  }

  ngOnInit() {
    console.log(this.postService);
    this.postService.getPosts().subscribe((postData) => {
      this.postData = postData;
    });
    this.boardService.getBoards().subscribe((boardData) => {
      this.boardData = boardData;
    });
  }
}


