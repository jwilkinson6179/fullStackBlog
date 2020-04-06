import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { PostService } from '../services/post/post.service';
import { PostListComponent } from '../posts/post-list/post-list.component';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatFormFieldModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GiphyService } from '../services/giphy.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { PostEditComponent } from '../posts/post-edit/post-edit.component';
import { PostAddComponent } from '../posts/post-add/post-add.component';
import { PostDeleteComponent } from '../posts/post-delete/post-delete.component';
import { BoardAddComponent } from '../boards/board-add/board-add.component';
import { BoardDeleteComponent } from '../boards/board-delete/board-delete.component';
import { BoardEditComponent } from '../boards/board-edit/board-edit.component';
import { BoardListComponent } from '../boards/board-list/board-list.component';
import { BoardViewComponent } from '../boards/board-view/board-view.component';
import {MatSelectModule} from "@angular/material/select";

const appRoutes: Routes = [
  { path: '', redirectTo: '/board-list', pathMatch: 'full' },
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
  },
  {
    path: 'board-list',
    component: BoardListComponent
  },
  {
    path: 'board-add',
    component: BoardAddComponent
  },
  {
    path: 'board-delete/:id',
    component: BoardDeleteComponent
  },
  {
    path: 'board-view/:id',
    component: BoardViewComponent
  },
  {
    path: 'board-edit/:id',
    component: BoardEditComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    PostListComponent,
    PostEditComponent,
    PostAddComponent,
    PostDeleteComponent,
    BoardAddComponent,
    BoardDeleteComponent,
    BoardEditComponent,
    BoardListComponent,
    BoardViewComponent
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
    RouterModule.forRoot(appRoutes),
    MatSelectModule,
    ReactiveFormsModule
  ],
  providers: [PostService, GiphyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
