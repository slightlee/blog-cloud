

### 访问路径

> http://host:port/swagger-ui/index.html

### SpringFox和SpringDoc区别

| SpringFox                                   | SpringDoc                                                    |
| :------------------------------------------ | :----------------------------------------------------------- |
| @Api                                        | @Tag                                                         |
| @ApiIgnore                                  | @Parameter(hidden = true)or@Operation(hidden = true)or@Hidden |
| @ApiImplicitParam                           | @Parameter                                                   |
| @ApiImplicitParams                          | @Parameters                                                  |
| @ApiModel                                   | @Schema                                                      |
| @ApiModelProperty                           | @Schema                                                      |
| @ApiOperation(value = "foo", notes = "bar") | @Operation(summary = "foo", description = "bar")             |
| @ApiParam                                   | @Parameter                                                   |
| @ApiResponse(code = 404, message = "foo")   | ApiResponse(responseCode = "404", description = "foo")       |
