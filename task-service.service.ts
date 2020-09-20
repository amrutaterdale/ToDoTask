import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {

  constructor(private http:HttpClient) { }

  saveRegisteredUser(registeredData)
  {
    return this.http.post("http://localhost:8080/TaskProject/registeredSave",registeredData);
  }

  regview()
  {
    return this.http.get("http://localhost:8080/TaskProject/registeredUserView");
  }

  taskview()
  {
    return this.http.get("http://localhost:8080/TaskProject/taskView");
    
  }
  tasksave(taskdata)
  {
    return this.http.post("http://localhost:8080/TaskProject/taskSave",taskdata);
    
  }

  updatetask(data)
  {
    return this.http.post("http://localhost:8080/TaskProject/taskupdate",data);
  }

  deletetask(tempobj)
  {
    return this.http.post("http://localhost:8080/TaskProject/taskdelete",tempobj);
  }

  activateUser(obj)
  {
    return this.http.post("http://localhost:8080/TaskProject/activate",obj);
  }

  deactivateUser(obj)
  {
    return this.http.post("http://localhost:8080/TaskProject/deactivate",obj);
  }
  checkbox(data)
  {
    return this.http.post("http://localhost:8080/TaskProject/check",data);
  }
  act_user(data)
  {
    return this.http.post("http://localhost:8080/TaskProject/loginuser",data);
  }
  actview()
  {
    return this.http.get("http://localhost:8080/TaskProject/loginview");
  }

  verify(data)
  {
    return this.http.post("http://localhost:8080/TaskProject/sendmail",data);
  }
  }
  

