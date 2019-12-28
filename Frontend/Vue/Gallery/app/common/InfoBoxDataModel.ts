export class Link {
  url: string;
  openMode: string;
  constructor(url: string, openMode?: string) {
    this.url = url;
    this.openMode = openMode;
  }
  static getLinkTarget(link: Link): string {
    let result = null;
    if (link && link.openMode != null) {
      if (link.openMode === 'NewTab') {
        result = '_blank';
      }
    }

    return result;
  }
}

export class InfoBoxDataModel {
  id: string;
  title?: string;
  number?: number;
  date?: Date;
  description?: string;
  hoverDescription?: string;
  link?: Link;
  tags?: Array<string>;
  pictureUrl?: string;
  bottomPictureUrl?: string;
}