import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  constructor(private http :HttpClient) { }
  post(member: any) {
    return this.http.post("http://localhost:8080/api/member",member);
  }
}
