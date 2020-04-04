import {Component, OnInit} from '@angular/core';
import {PostService} from './blog.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent  implements OnInit
{
  title = 'LoopyBlog';
  blogdata;
  constructor(private postService: PostService) {

  }

  ngOnInit() {
    console.log(this.postService);
    this.postService.getPosts().subscribe((blogData) => {
      this.blogdata = blogData;
    });
  }
}


