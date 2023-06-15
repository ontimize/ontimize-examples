import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CandidatesHomeComponent } from './home/candidates-home.component';


export const routes: Routes = [
  {
    path: '', component: CandidatesHomeComponent,
    data: {
      oPermission: {
        permissionId: 'candidates-table-route'
      }
    }
  }
  /*{ path: 'new', component: CandidatesNewComponent },
  {
    path: ':CUSTOMERID',
    component: CandidatesDetailComponent,
    data: {
      oPermission: {
        permissionId: 'customer-detail-permissions'
      }
    }
  }*/
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CandidatesRoutingModule { }

