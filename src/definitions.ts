export interface CheckMockLocationPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
