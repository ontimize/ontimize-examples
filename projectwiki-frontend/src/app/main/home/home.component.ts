import { Component, Injector, OnInit } from '@angular/core';
import { AuthService } from 'ontimize-web-ngx';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  protected authService: AuthService;

  constructor(
    protected injector: Injector
  ) {
    this.authService = this.injector.get(AuthService);
  }

  ngOnInit() {
    // nothing to do
  }

  navigate() {
    this.authService.logoutWithConfirmation();
  }

}
