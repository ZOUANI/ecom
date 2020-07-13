import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { UserVo } from '../../controller/model/User.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public logout() {
    return of([localStorage.removeItem('user')]);
  }

  constructor(private http: HttpClient) { }

  public login(email: string) {
    return this.http.post<UserVo>(`${environment.apiUrl}auth/login`, email).pipe(
      map((user: UserVo) => ({
        id: user.id,
        firstName: user.firstName,
        lastName: user.lastName,
        authority: user.authorityVo,
        email: user.email
      }))
    );
  }
}
