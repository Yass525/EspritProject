import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { ToastrModule } from "ngx-toastr";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { AuthInterceptor } from "./auth/auth.interceptor";
import { ForbiddenComponent } from "./forbidden/forbidden.component";
import { HeaderComponent } from "./header/header.component";
import { UserService } from "./shared/user.service";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxAnimationsModule } from 'ngx-animations';
import { NgModule } from "@angular/core";
import { HomeComponent } from "./home/home.component";
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { CookieService } from 'ngx-cookie-service';
import { RouterModule } from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ForbiddenComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgxAnimationsModule,
    ToastrModule.forRoot({
      progressBar: true
    }),
    FormsModule,
    MatSnackBarModule,

  ],
  providers: [UserService, {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  },CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
