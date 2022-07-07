export class Course {
  private _code: string = '';
  private _title: string = '';
  private _description: string = '';
  private _topics: string[] = [];

  constructor(
    code: string,
    title: string,
    description: string,
    topics: string[]
  ) {
    this._code = code;
    this._title = title;
    this._description = description;
    this._topics = topics;
  }

  get code(): string {
    return this._code;
  }

  set code(value: string) {
    this._code = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get topics(): string[] {
    return this._topics;
  }

  set topics(value: string[]) {
    this._topics = value;
  }
}
