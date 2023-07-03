import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {
  AuthService,
  OFileInputComponent,
  OFileItem,
  OIntegerInputComponent,
  OTableButtonComponent,
  OTableComponent,
  OTextareaInputComponent
} from 'ontimize-web-ngx';

import { CandidatesNaming } from '../candidates-common/naming';


@Component({
  selector: 'app-candidates-view',
  templateUrl: './candidates-view.component.html',
  styleUrls: ['./candidates-view.component.scss']
})
export class CandidatesViewComponent implements OnInit {

  @ViewChild("interviewComment", { static: false }) interviewComment: OTextareaInputComponent;
  @ViewChild("uploadFileButton", { static: false }) uploadFileButton: OTableButtonComponent;
  @ViewChild("inputElem", { static: false }) inputElem: ElementRef;
  @ViewChild("fileInput", { static: false }) fileInputElem: OFileInputComponent;
  @ViewChild("documentsTable", { static: false }) documentsTable: OTableComponent; //busca en el html el componente que se llame por "x"
  @ViewChild("idCandidateInput", { static: false }) idCandidateInput: OIntegerInputComponent;//2 view child

  public workspace: any = { name: 'default', data: { id: [1] } };


  candidateId: Number;

  constructor(
    private actRoute: ActivatedRoute,
    private authService: AuthService,
    private httpClient: HttpClient) {
  }

  ngOnInit() {
    let urlParams = this.actRoute.snapshot.params;
    this.candidateId = Number(urlParams.ID);
  }

  // ngAfterViewInit() {
  //   this.uploadFileButton.onClick.subscribe(event => {
  //     this.inputElem.nativeElement.click();
  //   });
  // }

  genderData() {
    return CandidatesNaming.prototype.genderData();

  }

  statusData() {
    return CandidatesNaming.prototype.statusData();

  }

  originData() {
    return CandidatesNaming.prototype.originData();
  }

  experienceLevelData() {
    return CandidatesNaming.prototype.experienceLevelData();
  }

  profileData() {
    return CandidatesNaming.prototype.profileData();

  }

  onInterviewRowSelected(row) {
    this.interviewComment.setValue(row["COMMENT"]);
  }



  inputChanged(event) {
    let file = this.inputElem.nativeElement.files[0];
    let ofile: OFileItem = new OFileItem(file, this.fileInputElem.uploader);
    this.fileInputElem.uploader.addFile(ofile);
    this.fileInputElem.upload();
  }

  fileInputElemError(event) {
    console.error("Error on file upload: " + event);
  }

  fileInputElemUpload(event) {
    let fileId = event.response.data.ID;
    this.fileInputElem.uploader.clear();
    //this.setCandidate(fileId);
  }

  // setCandidate(fileId) {
  //   // fill data
  //   let data_filter = {};
  //   data_filter["ID"] = fileId;

  //   let data_data = {};

  //   data_data["CANDIDATE"] = this.candidateId;
  //   // make req
  //   let url = `${CONFIG.apiEndpoint}/files/file`;
  //   let data = { filter: data_filter, data: data_data };
  //   console.log(data);
  //   let options = { headers: this.supplyHttpSrv.buildHeaders() };
  //   this.httpClient.put(url, data, options).subscribe(
  //     (res: any) => {
  //       this.documentsTable.refresh();
  //       console.log("Updated file candidate.");
  //     },
  //     err => {
  //       console.error("Error on file candidate update: " + err);
  //     }
  //   );
  // }

  buildHeaders() {
    let sessionInfo = this.authService.getSessionInfo();
    var headers = new Headers();
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Content-Type', 'application/json;charset=UTF-8');
    var authorizationToken = 'Bearer ' + sessionInfo.id;
    headers.append('Authorization', authorizationToken);
    return headers;
  }

  // Needed to avoid the text editor bug with one row.
  loadedDocumentsDone() {
    if (this.documentsTable.getDataArray.length > 0) {
      this.documentsTable.setSelected(this.documentsTable.getDataArray()[0]);
    }
  }

  setWorkspaceS3(data: any) {
    return { name: 'default', data: { id: data['ID'] } };
  }


}
