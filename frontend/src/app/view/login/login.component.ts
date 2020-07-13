import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../controller/service/auth.service';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(private router: Router, private authService: AuthService, private toastrService: ToastrService) { }

  ngOnInit(): void { }

  login(f: NgForm) {
    if (f.invalid) {
      return;
    }

    this.authService.login(f.value).subscribe(data => {
      localStorage.setItem('user', JSON.stringify(data));
      // tslint:disable-next-line:max-line-length
      this.router.navigate(['dashboard']).then((_) => this.toastrService.success(`${data.lastName} ${data.firstName}`, 'Authentication successful', { timeOut: 5000 }));
    }, (error: HttpErrorResponse) => this.toastrService.error(error.error.message, 'Authentication failed', { timeOut: 1500 }));
  }
}
