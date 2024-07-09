import { WebPlugin } from '@capacitor/core';

import type { CheckMockLocationPlugin } from './definitions';

export class CheckMockLocationWeb extends WebPlugin implements CheckMockLocationPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
