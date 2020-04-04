import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestpostsComponent } from './testposts/testposts.component';
import { HttpClientModule } from '@angular/common/http';
import { PostService } from './blog.service';
import { PostListComponent } from './post-list/post-list.component';
import { PostSubmitComponent } from './post-submit/post-submit.component';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatFormFieldModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GiphyService } from './shared/giphy.service';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { PostEditComponent } from './post-edit/post-edit.component';
import { PostAddComponent } from './post-add/post-add.component';
import { PostDeleteComponent } from './post-delete/post-delete.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/post-list', pathMatch: 'full' },
  {
    path: 'post-list',
    component: PostListComponent
  },
  {
    path: 'post-add',
    component: PostAddComponent
  },
  {
    path: 'post-delete/:id',
    component: PostDeleteComponent
  },
  {
    path: 'post-edit/:id',
    component: PostEditComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    TestpostsComponent,
    PostListComponent,
    PostSubmitComponent,
    PostEditComponent,
    PostAddComponent,
    PostDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    MatFormFieldModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [PostService, GiphyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
