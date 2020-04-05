import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { GiphyService } from '../../services/giphy.service';
import { NgForm } from '@angular/forms';
import { PostService } from '../../services/post/post.service';

@Component({
  selector: 'app-post-edit',
  templateUrl: './post-edit.component.html',
  styleUrls: ['./post-edit.component.scss']
})
export class PostEditComponent implements OnInit {

  post: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private postService: PostService,
              private giphyService: GiphyService) { }

  ngOnInit() {this.sub = this.route.params.subscribe(params => {
    const id = params['id'];
    if (id) {
      this.postService.get(id).subscribe((car: any) => {
        if (car) {
          this.post = car;
          this.post.href = car._links.self.href;
          // this.giphyService.get(car.name).subscribe(url => car.giphyUrl = url);
        } else {
          console.log(`Post with id '${id}' not found, returning to list`);
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
    this.router.navigate(['/post-list']);
  }

  save(form: NgForm) {
    this.postService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.postService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

}
