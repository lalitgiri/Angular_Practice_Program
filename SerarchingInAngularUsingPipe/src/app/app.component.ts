import { Component } from '@angular/core';
import {server} from './server';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  appStatus=new Promise((resolve,reject)=>{
    setTimeout(()=>{
      resolve('stable');
    },0);
  });
  servers = [{
                  instanceType: 'medium',
                  name: 'Production Server',
                  status: 'stable',
                  started: new Date(15, 1, 2017)
                },
              {
                instanceType: 'large',
                  name: 'User Database',
                    status: 'stable ',
                      started: new Date(15, 1, 2017)
              },
              {
                instanceType: 'small',
                  name: 'Development Server',
                    status: 'offline',
                      started: new Date(15, 1, 2017)
              },
              {
                instanceType:'small',
                name:'Testing Environment Server',
                status:'stable',
                started:new Date(15,1,2017)
              }
            ];
            filteredStatus='';

   // getStatusClasses(server:{instanceType:string,name:string,status:string,started:Date})
    getStatusClasses(server:server)
    {

        return{
          'list-group-item-success':server.status==='stable',
          'list-group-item-warning':server.status==='offline',
          'list-group-item-danger':server.status==='critical'
          
        };
      }

      onAddServer(){
        this.servers.push({
          instanceType:'small',
          name:'New Server',
          status:'stable',
          started:new Date(15,1,2017)
        })
      }

}
