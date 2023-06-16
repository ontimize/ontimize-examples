import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CandidatesHomeComponent } from './home/candidates-home.component';
import { CandidatesNewComponent } from './new/candidates-new.component';
import { CandidatesDetailComponent } from './detail/candidates-detail.component';


export const routes: Routes = [
  {
    path: '', component: CandidatesHomeComponent,
    data: {
      oPermission: {
        permissionId: 'candidates-table-route'
      }
    }
  },
  {
    path: 'new', component: CandidatesNewComponent,
    data: {
      oPermission: {
        permissionId: 'candidates-table-route'
      }
    }
  },
  {
    path: ':ID',
    component: CandidatesDetailComponent,
    data: {
      oPermission: {
        permissionId: 'candidates-table-route'
      }
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CandidatesRoutingModule { }

