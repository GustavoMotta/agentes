import { Component, OnInit } from '@angular/core';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { UploadService } from 'src/app/services/upload.service';
import { IfStmt } from '@angular/compiler';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  currentFile?: File;
  progress = 0;
  message = '';

  fileName = 'Selecione um arquivo';
  fileInfos?: any[] = [];

  constructor(private uploadService: UploadService) { }

  ngOnInit(): void {
  }

  selectFile(event: any): void {
    if (event.target.files && event.target.files[0]) {
      const file: File = event.target.files[0];
      if (file.type !== 'text/xml') {
        this.message = "Formato do arquivo invalido.";
        return;
      }
      this.currentFile = file;
      this.fileName = this.currentFile.name;
    } else {
      this.fileName = 'Selecione um arquivo';
    }
  }

  upload(): void {
    this.progress = 0;
    this.message = "";
    console.log(this.currentFile)
    if (this.currentFile) {
      this.uploadService.upload(this.currentFile).subscribe({
        next: (event: any) => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progress = Math.round(100 * event.loaded / event.total);
          } else if (event instanceof HttpResponse) {
            console.log(event.body);
            this.message = "Upload realizado.";
            this.fileName = 'Selecione um arquivo';
            this.currentFile = undefined;
            this.progress = 0;
          }
        },
        error: (err: any) => {
          this.progress = 0;

          if (err.error && err.error.message) {
            this.message = err.error.message;
          } else {
            this.message = 'Falha ao realizar upload.';
          }

          this.currentFile = undefined;
        }
      });
    }

  }
}
