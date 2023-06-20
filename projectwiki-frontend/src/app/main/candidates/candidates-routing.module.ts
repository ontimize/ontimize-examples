import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CandidatesHomeComponent } from './home/candidates-home.component';
import { CandidatesViewComponent } from './candidates-view/candidates-view.component';


export const routes: Routes = [
  { path: '', component: CandidatesHomeComponent },
  { path: ':ID', component: CandidatesViewComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CandidatesRoutingModule { }

